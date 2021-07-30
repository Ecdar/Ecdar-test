import parsing.RelationParserFacade
import parsing.RelationVisitor
import java.io.File
import kotlin.test.Test
import kotlin.test.assertTrue

internal class RelationParserFacadeTest {

    @Test
    fun parse1() {
        var result = RelationParserFacade.parse("A.A || A.B </= B.B")
        assertTrue(result?.exception == null)
    }

    @Test
    fun parse2() {
        var result = RelationParserFacade.parse("A.A || A.B <= B.B \n ")
        assertTrue(result?.exception == null)
        result?.facts()?.fact()
    }

    @Test
    fun parse3() {
        var result = RelationParserFacade.parse("A.A || A.B <= B.B \n A.A || A.B <= B.B ")

        assertTrue(result?.exception == null)
    }

    @Test
    fun visit1() {
        val parse = RelationParserFacade.parse(
            File("src/test/kotlin/facts.txt").readText(Charsets.UTF_8))!!
        val visitor = RelationVisitor()
        parse.accept(visitor)
        for (comp in visitor.components) {
            val refines = comp.thisRefines.toString()
            val oRefines = comp.refinesThis.toString()

            println("$comp refines $refines and $oRefines refine it")
        }
    }
}