package tests

import java.lang.Exception

class NotSatisfiedTest(projectPath: String, query: String) : Test(projectPath, query) {
    override fun getResult(stdout: String): Boolean? {
        return if (stdout == ""){
            null
        }else {
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
}