package tests.testgeneration

import tests.NotSatisfiedTest
import tests.SatisfiedTest
import TestGenerator
import tests.TestSuite
import parsing.System

fun TestGenerator.addConsistencyTests(): TestGenerator{
    return addGenerator(ConsistencyTests())
}

class ConsistencyTests : TestRule {
    override fun getTestSuiteName(): String = "Consistency"

    override fun searchSystem(system: System, testSuite: TestSuite) {
        if (system.isLocallyConsistent.isPresent){
            if (system.isLocallyConsistent.get()){
                testSuite.addTest(
                    SatisfiedTest(
                    system.getProjectFolder(),
                    "consistency: ${system.getName()}"
                )
                )
            }else{
                testSuite.addTest(
                    NotSatisfiedTest(
                    system.getProjectFolder(),
                    "consistency: ${system.getName()}"
                )
                )
            }
        }
    }
}