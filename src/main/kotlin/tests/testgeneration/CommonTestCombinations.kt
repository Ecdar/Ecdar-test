package tests.testgeneration

import TestGenerator

fun TestGenerator.addAllTests():TestGenerator {
    this.addNotRefinesTests()
        .addRefinementTests()
        .addSelfRefinementTests()
        .addConsistencyTests()

    return this
}