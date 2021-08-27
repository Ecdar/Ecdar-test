import parsing.EngineConfiguration
import tests.Test
import java.io.IOException

class Executor(val engineConfig: EngineConfiguration) {

    fun runTest(test: Test): TestResult {
        val reader = runToReader(test)
        return getTestResult(test, reader)
    }

    private fun runToReader(test: Test): QueryResultReader {
        val command = engineConfig.getCommand(test.projectPath, test.query)
        val stdout = runCommand(command)!!
        try {
        return QueryResultReader(stdout)
        } catch (e: Exception) {
            throw Exception("Query: ${test.query} lead to unexpected modelchecker output.")
        }
    }

    private fun getTestResult(test: Test, reader: QueryResultReader): TestResult {
        val result = test.getResult(reader)
        result.engine = engineConfig.name
        return result
    }

    private fun runCommand(command: String): String? {

        return try {
            val parts = splitArguments(command)
            val proc = ProcessBuilder(*parts.toTypedArray())
                .redirectOutput(ProcessBuilder.Redirect.PIPE)
                .redirectError(ProcessBuilder.Redirect.INHERIT)
                .start()

            val out = proc.inputStream.bufferedReader().readText()
            proc.destroyForcibly()
            out
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }

    private fun splitArguments(command: String): ArrayList<String> {
        val parts = ArrayList<String>()
        val segments = command.split("\"".toRegex())
        var isQuoted = false
        for (segment in segments) {
            if (segment == "")
                continue

            if (isQuoted) {
                parts.add(segment)
            } else {
                parts.addAll(segment.trim().split("\\s".toRegex()))
            }

            isQuoted = !isQuoted
        }
        return parts
    }

}