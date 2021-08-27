package tests

import QueryResult
import QueryResultReader
import TestResult

abstract class Test(val testSuite: String, val projectPath: String, val query: String) {
    abstract fun getResult(resultReader: QueryResultReader): TestResult

    protected fun checkQuery(result: QueryResult) {
        if (result.query != query)
            throw Exception("Query doesnt match given result")
    }
}