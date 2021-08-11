import parsing.EngineConfiguration
import tests.Test
import tests.TestSuite
import java.io.IOException
import java.util.concurrent.ConcurrentLinkedQueue

class Executor(private val engineConfigs: Collection<EngineConfiguration>) {

    fun runTests(testSuites: ArrayList<TestSuite>){
        var testCount = 0
        val failedTests = ConcurrentLinkedQueue<Test>()
        val crashedTests = ConcurrentLinkedQueue<Test>()

        for (testSuite in testSuites) {
            testCount += testSuite.tests.count()
            testSuite.tests.parallelStream().forEach{ test ->
                for (engineConfig in engineConfigs){
                    val command = engineConfig.getCommand(test.projectPath, test.query)
                    val stdout = runCommand(command)!!

                    when (test.getResult(stdout)) {
                        true -> {println("${testSuite.name}::${test.projectPath}::${test.query}:  Passed")}
                        false -> {println("${testSuite.name}::${test.projectPath}::${test.query}:  Failed"); failedTests.add(test)}
                        null -> {println("${testSuite.name}::${test.projectPath}::${test.query}:  Error"); crashedTests.add(test)}
                    }
                }
            }
        }
        val passedCount = testCount - failedTests.count() - crashedTests.count()


        println("tests.Test results: $passedCount passed; ${failedTests.count()} failed; ${crashedTests.count()} crashed")
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