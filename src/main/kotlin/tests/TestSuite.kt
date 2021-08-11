package tests

import tests.Test

class TestSuite(val name: String) {
    val tests = ArrayList<Test>()

    fun addTest(test: Test){
        tests.add(test)
    }
}