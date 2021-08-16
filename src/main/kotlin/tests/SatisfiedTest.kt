package tests

import TestResult

class SatisfiedTest(testSuite: String, projectPath: String, query: String) : Test(testSuite, projectPath, query) {
    override fun getResult(stdout: String): TestResult {
        return when {
            stdout.endsWith("$query -- Property is NOT satisfied\n") -> {
                TestResult(this, "Failed", stdout)
            }
            stdout.endsWith("$query -- Property is satisfied\n") -> {
                TestResult(this, "Passed", stdout)
            }
            else -> {
                println(stdout)
                throw Exception("Unexpected stdout from engine")
            }
        }
    }
}