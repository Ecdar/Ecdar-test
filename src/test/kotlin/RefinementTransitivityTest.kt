import analytics.RefinementsAnalysis
import facts.RelationLoader
import kotlin.test.Test
import proofs.addRefinementProofs

internal class RefinementTransitivityTest {

    @Test
    fun visit1() {
        val refinementAnalytics = RefinementsAnalysis()
        val searcher = ProofSearcher()
            .addRefinementProofs()
            .addAnalytic(refinementAnalytics)

        searcher.findNewRelations(RelationLoader.relations)

        refinementAnalytics.printFindings()
    }

    @Test
    fun refinementTransitivityTest1(){
        val proofSearcher = ProofSearcher().addRefinementProofs()

        val factSheet = """
            AG.A <= AG.B
            AG.B <= AG.C
        """.trimIndent()

        val expectedSheet = """
            AG.A <= AG.C
        """.trimIndent()

        assert(proofSearchContains(factSheet, expectedSheet,proofSearcher))
    }

    @Test
    fun refinementTransitivityTest2(){
        val proofSearcher = ProofSearcher().addRefinementProofs()

        val factSheet = """
            AG.A <= AG.B
            AG.B <= AG.C
            AG.C <= AG.D
        """.trimIndent()

        val expectedSheet = """
            AG.A <= AG.D
        """.trimIndent()

        assert(proofSearchContains(factSheet, expectedSheet,proofSearcher))
    }

    @Test
    fun refinementTransitivityTest3(){
        val proofSearcher = ProofSearcher().addRefinementProofs()

        val factSheet = """
            AG.A <= AG.B
            AG.C <= AG.C
        """.trimIndent()

        val expectedSheet = """
            AG.A <= AG.C
        """.trimIndent()

        assert(!proofSearchContains(factSheet, expectedSheet,proofSearcher))
    }

    @Test
    fun refinementTransitivityCircularTest(){
        val proofSearcher = ProofSearcher().addRefinementProofs()

        val factSheet = """
            AG.A <= AG.B
            AG.B <= AG.C
            AG.C <= AG.A
        """.trimIndent()

        val expectedSheet = """
            AG.A <= AG.C
            AG.B <= AG.A
            AG.C <= AG.B
        """.trimIndent()

        assert(proofSearchContains(factSheet, expectedSheet,proofSearcher))
    }
}