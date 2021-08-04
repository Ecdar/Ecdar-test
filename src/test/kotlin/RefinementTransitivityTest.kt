import facts.RelationLoader
import parsing.RelationParserFacade
import parsing.RelationVisitor
import java.io.File
import kotlin.test.Test
import kotlin.test.assertTrue
import parsing.System

internal class RefinementTransitivityTest {

    @Test
    fun visit1() {
        println("Refinements: " + refinementCount(RelationLoader.relations))
        println("Components: ${RelationLoader.relations.size}")

        var searcher = ProofSearcher()
        var newRelation = searcher.findNewRelations(RelationLoader.relations)

        println("Refinements: " + refinementCount(newRelation))
        println("Components: ${newRelation.size}")
    }

    fun refinementCount(components: ArrayList<System>): Int{
        var count = 0
        for (comp in components) {
            count += comp.thisRefines.count()
        }

        return count
    }
}