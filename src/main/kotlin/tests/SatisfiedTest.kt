package tests

import java.lang.Exception

class SatisfiedTest(projectPath: String, query: String) : Test(projectPath, query) {
    override fun getResult(stdout: String): Boolean? {
        return if (stdout == ""){
            null
        }else {
            return when {
                stdout.endsWith("$query -- Property is NOT satisfied\n") -> {
                    false
                }
                stdout.endsWith("$query -- Property is satisfied\n") -> {
                    true
                }
                else ->{
                    throw Exception("Unexpected stdout from engine")
                }
            }
        }
    }
}