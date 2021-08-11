package tests.testgeneration
import parsing.System
import tests.TestSuite

interface TestRule {
    fun getTestSuiteName(): String
    fun searchSystem(system: System, testSuite: TestSuite)
}