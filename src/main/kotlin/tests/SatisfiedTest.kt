package tests

import QueryResultReader
import TestResult

class SatisfiedTest(testSuite: String, projectPath: String, query: String) : Test(testSuite, projectPath, query) {
    override fun getResult(resultReader: QueryResultReader): TestResult {
        val queryResult = resultReader.nextResult()

        checkQuery(queryResult)

        return when (queryResult.result) {
            "Property is NOT satisfied" -> {
                TestResult(this, false, queryResult)
            }
            "Property is satisfied" -> {
                TestResult(this, true, queryResult)
            }
            else -> {
                println(queryResult)
                throw Exception("Unexpected stdout from engine")
            }
        }
    }
}