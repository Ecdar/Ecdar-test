import org.junit.Test
import proofs.SelfRefinement

class SelfRefinementTest {
    @Test
    fun selfRefinementTest1(){
        val proofSearcher = ProofSearcher().addProof(SelfRefinement())

        val factSheet = """
            locally-consistent: AG.A
        """.trimIndent()

        val expectedSheet = """
            AG.A <= AG.A
        """.trimIndent()

        assert(proofSearchContains(factSheet, expectedSheet,proofSearcher))
    }

    @Test
    fun selfRefinementTest2(){
        val proofSearcher = ProofSearcher().addProof(SelfRefinement())

        val factSheet = """
            AG.A <= AG.B
        """.trimIndent()

        val expectedSheet = """
            AG.A <= AG.A
            AG.B <= AG.B
        """.trimIndent()

        assert(proofSearchContains(factSheet, expectedSheet,proofSearcher))
    }
}