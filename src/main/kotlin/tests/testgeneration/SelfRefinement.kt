package tests.testgeneration

import tests.SatisfiedTest
import TestGenerator
import tests.TestSuite
import parsing.System

fun TestGenerator.addSelfRefinementTests(): TestGenerator{
    return addGenerator(SelfRefinement())
}

class SelfRefinement : TestRule {
    override fun getTestSuiteName(): String = "SelfRefinement"

    override fun searchSystem(system: System, testSuite: TestSuite) {
        testSuite.addTest(
            SatisfiedTest(system.getProjectFolder(), "refinement: ${system.getName()} <= ${system.getName()}")
        )
    }
}