package tests

class SatisfiedTest(testSuite: String, projectPath: String, query: String) : Test(testSuite, projectPath, query) {
    override fun getResult(stdout: String): Boolean {
        return when {
            stdout.endsWith("$query -- Property is NOT satisfied\n") -> {
                false
            }
            stdout.endsWith("$query -- Property is satisfied\n") -> {
                true
            }
            else -> {
                throw Exception("Unexpected stdout from engine")
            }
        }
    }
}