import analytics.RefinementsAnalysis
import facts.RelationLoader
import kotlin.test.Test
import proofs.addRefinementProofs

internal class RefinementTransitivityTest {

    @Test
    fun visit1() {
        val refinementAnalytics = RefinementsAnalysis()
        var searcher = ProofSearcher()
            .addRefinementProofs()
            .addAnalytic(refinementAnalytics)

        searcher.findNewRelations(RelationLoader.relations)

        refinementAnalytics.printFindings()
    }
}