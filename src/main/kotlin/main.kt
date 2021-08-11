import com.beust.klaxon.Klaxon
import facts.RelationLoader
import parsing.EngineConfiguration
import proofs.addAllProofs
import tests.testgeneration.addAllTests
import java.io.File

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
    val engines = Klaxon().parseArray<EngineConfiguration>(File("configuration.json"))!!
    Executor(engines).runTests(testSuites)
}