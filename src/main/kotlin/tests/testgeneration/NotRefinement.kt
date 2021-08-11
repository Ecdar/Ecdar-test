package tests.testgeneration

import tests.NotSatisfiedTest
import TestGenerator
import tests.TestSuite
import parsing.System

fun TestGenerator.addNotRefinesTests(): TestGenerator{
    return addGenerator(NotRefinement())
}

class NotRefinement : TestRule {
    override fun getTestSuiteName(): String = "NotRefines"

    override fun searchSystem(system: System, testSuite: TestSuite) {
        for (other in system.thisNotRefines){
            testSuite.addTest(
                NotSatisfiedTest(system.getProjectFolder(), "refinement: ${system.getName()} <= ${other.getName()}")
            )
        }
    }
}