import parsing.EngineConfiguration
import tests.Test
import java.io.IOException

class Executor(val engineConfig: EngineConfiguration) {

    fun runTest(test: Test): Boolean{
        val command = engineConfig.getCommand(test.projectPath, test.query)
        val stdout = runCommand(command)!!

        return test.getResult(stdout)
    }

    private fun runCommand(command: String): String? {
        return try {
            val parts = command.split("\\s".toRegex())
            val proc = ProcessBuilder(*parts.toTypedArray())
                .redirectOutput(ProcessBuilder.Redirect.PIPE)
                .redirectError(ProcessBuilder.Redirect.INHERIT)
                .start()

            val out = proc.inputStream.bufferedReader().readText()
            proc.destroyForcibly()
            out
        } catch(e: IOException) {
            e.printStackTrace()
            null
        }
    }

}