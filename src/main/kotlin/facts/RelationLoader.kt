package facts

import parsing.RelationParserFacade
import parsing.RelationVisitor
import parsing.System
import java.io.File

object RelationLoader {
    private val visitor = RelationVisitor()
    val relations: ArrayList<System>

    val prefixMap = mapOf(
        "AG" to "samples/json/AG",
        "Uni" to "samples/json/EcdarUniversity",
        "Conjunction" to "samples/json/Conjunction",
        "Conjun" to "samples/xml/conjun.xml",
        "BigRefinement" to "samples/json/BigRefinement",
        "DelayAdd" to "samples/json/DelayAdd",
        "Unspec" to "samples/json/Unspec",
        "Loop" to "samples/xml/loop.xml",
        "Delay" to "samples/xml/delayRefinement.xml",
        "Extrapolation" to "samples/xml/extrapolation_test.xml",
        "Misc" to "samples/xml/misc_test.xml",
        "Cons" to "samples/xml/ConsTests.xml"
    )

    init {
        val parse = RelationParserFacade.parse(
            File("src/main/kotlin/facts/relations.txt").readText(Charsets.UTF_8)
        )!!
        parse.accept(visitor)
        relations = visitor.components
    }
}