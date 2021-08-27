package tests.testgeneration

import TestGenerator

fun TestGenerator.addAllTests(): TestGenerator {
    this.addNotRefinesTests()
        .addRefinementTests()
        .addConsistencyTests()
        .addImpliedRefinementTests()

    return this
}