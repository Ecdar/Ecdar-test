import tests.testgeneration.TestRule
import parsing.System
import tests.Test

class TestGenerator {
    private val testGenerators = ArrayList<TestRule>()

    fun addGenerator(generator: TestRule): TestGenerator{
        testGenerators.add(generator)
        return this
    }

    fun generateTests(systems: ArrayList<System>) : Collection<Test>{
        val generatedTests = ArrayList<Test>()

        for (testGen in testGenerators){
            for (system in systems) {
                val newTests = testGen.getTests(system)
                generatedTests.addAll(newTests)
            }
        }

        return generatedTests
    }
}