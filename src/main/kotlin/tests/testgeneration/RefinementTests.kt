package tests.testgeneration
import tests.SatisfiedTest
import TestGenerator
import parsing.System
import tests.TestSuite

fun TestGenerator.addRefinementTests(): TestGenerator{
    return addGenerator(RefinementTests())
}

class RefinementTests : TestRule {
    override fun getTestSuiteName(): String = "Refinement"

    override fun searchSystem(system: System, testSuite: TestSuite) {
        for (other in system.thisRefines){
            if (system == other) {
                continue //Skip self refinement so it can be its own testsuite
            }

            testSuite.addTest(
                SatisfiedTest(system.getProjectFolder(), "refinement: ${system.getName()} <= ${other.getName()}")
            )
        }
    }

}