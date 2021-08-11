import facts.RelationLoader
import parsing.EngineConfiguration
import proofs.addAllProofs
import tests.testgeneration.addAllTests

fun main() {
    val path = System.getProperty("user.dir")

    println("Working Directory = $path")

    println("Loading relation sheet")
    val relations = RelationLoader.relations
    println("Finding relations")
    val allRelations = ProofSearcher().addAllProofs().findNewRelations(relations)
    println("Generating tests")
    val testSuites = TestGenerator().addAllTests().generateTests(allRelations)

    println("Running tests")
    val engine = EngineConfiguration("C:/Users/Thorulf/Desktop/Reveaal.exe", "-i C:/Users/Thorulf/Desktop/{input} \"{query}\"")
    println("Command: ${engine.getCommand("samples/json/EcdarUniversity", "refinement: Adm2 <= (HalfAdm1 && HalfAdm2)")}")
    Executor(engine).runTests(testSuites)
}