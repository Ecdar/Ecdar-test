package tests

abstract class Test(val projectPath: String, val query: String) {
    abstract fun getResult(stdout: String) : Boolean?
}