import tests.testgeneration.TestRule
import parsing.System
import tests.TestSuite

class TestGenerator {
    private val testGenerators = ArrayList<TestRule>()

    fun addGenerator(generator: TestRule): TestGenerator{
        testGenerators.add(generator)
        return this
    }

    fun generateTests(systems: ArrayList<System>) : ArrayList<TestSuite>{
        val testSuites = HashMap<String, TestSuite>()

        for (testGen in testGenerators){
            if (!testSuites.containsKey(testGen.getTestSuiteName())){
                testSuites[testGen.getTestSuiteName()] = TestSuite(testGen.getTestSuiteName())
            }

            val testSuite = testSuites[testGen.getTestSuiteName()]!!

            for (system in systems) {
                testGen.searchSystem(system, testSuite)
            }
        }

        return ArrayList(testSuites.values)
    }
}