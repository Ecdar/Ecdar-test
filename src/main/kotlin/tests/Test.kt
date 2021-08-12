package tests

abstract class Test(val testSuite: String, val projectPath: String, val query: String) {
    abstract fun getResult(stdout: String): Boolean
}