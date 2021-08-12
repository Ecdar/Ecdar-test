package tests

import java.lang.Exception

class NotSatisfiedTest(testSuite: String, projectPath: String, query: String) : Test(testSuite, projectPath, query) {
    override fun getResult(stdout: String): Boolean {
        return when {
            stdout.endsWith("$query -- Property is NOT satisfied\n") -> {
                true
            }
            stdout.endsWith("$query -- Property is satisfied\n") -> {
                false
            }
            else ->{
                println(stdout)
                throw Exception("Unexpected stdout from engine")
            }
        }
    }
}