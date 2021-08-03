import analytics.ComponentsAdded
import analytics.RefinementsAnalysis
import facts.RelationLoader
import parsing.*
import proofs.ConsistentCompositions
import proofs.addConsistencyProofs
import java.io.File
import kotlin.reflect.typeOf
import kotlin.test.Test
import kotlin.test.assertTrue

internal class ConsistencyTests {

    @Test
    fun consistentComponents() {
        val consistencyCount = consistencyCount(RelationLoader.relations)
        println("Consistent: " + consistencyCount)

        assert(consistencyCount == 10)
    }

    @Test
    fun inconsistentComponents() {
        val nonConsistencyCount = nonConsistencyCount(RelationLoader.relations)
        println("Consistent: " + nonConsistencyCount)

        assert(nonConsistencyCount == 11)
    }

    @ExperimentalStdlibApi
    @Test
    fun visit1() {
        val compsAddedAnalysis = ComponentsAdded(arrayListOf(typeOf<ConsistentCompositions>()))
        val searcher = ProofSearcher()
            .addConsistencyProofs()
            .addAnalytic(compsAddedAnalysis)

        searcher.findNewRelations(RelationLoader.relations)

        compsAddedAnalysis.printFindings()
    }

    fun consistencyCount(components: ArrayList<System>): Int{
        var count = 0
        for (comp in components) {
            if (comp.isLocallyConsistent.orElse(false)){
                count++
            }
        }

        return count
    }
    fun nonConsistencyCount(components: ArrayList<System>): Int{
        var count = 0
        for (comp in components) {
            if (!comp.isLocallyConsistent.orElse(true)){
                count++
            }
        }

        return count
    }
}