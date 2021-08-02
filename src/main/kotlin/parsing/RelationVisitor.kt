package parsing

import parser.RelationParser
import parser.RelationParserBaseVisitor
import java.util.*
import kotlin.collections.ArrayList

class RelationVisitor : RelationParserBaseVisitor<System?>() {

    var components = ArrayList<System>()

    override fun visitRefinement(ctx: RelationParser.RefinementContext?): System? {
        val left = ctx?.left?.accept(this)!!
        val right = ctx.right?.accept(this)!!
        left.refinesOther(right)
        right.otherRefines(left)
        return null
    }

    override fun visitNonrefinement(ctx: RelationParser.NonrefinementContext?): System? {
        val left = ctx?.left?.accept(this)!!
        val right = ctx.right?.accept(this)!!
        left.notRefinesOther(right)
        right.otherNotRefines(left)
        return null
    }

    override fun visitSystem(ctx: RelationParser.SystemContext?): System? {
        ctx?.conj_system()?.let { return it.accept(this) }

        val left = ctx?.system(0)?.accept(this)
        val right = ctx?.system(1)?.accept(this)

        return addOrGet(Composition(left!!, right!!))
    }

    override fun visitConj_system(ctx: RelationParser.Conj_systemContext?): System? {
        ctx?.term()?.let { return it.accept(this) }

        val left = ctx?.conj_system(0)?.accept(this)
        val right = ctx?.conj_system(1)?.accept(this)

        return addOrGet(Conjunction(left!!, right!!))
    }

    override fun visitTerm(ctx: RelationParser.TermContext?): System? {
        ctx?.system()?.let { return it.accept(this) }
        val comp = Component(ctx?.prefix?.text!!, ctx?.comp?.text!!)

        return addOrGet(comp)
    }

    override fun visitLocallyconsistent(ctx: RelationParser.LocallyconsistentContext?): System? {
        val comp = ctx?.comp?.accept(this)!!

        comp.isLocallyConsistent = Optional.of(true)
        return null
    }

    override fun visitNotlocallyconsistent(ctx: RelationParser.NotlocallyconsistentContext?): System? {
        val comp = ctx?.comp?.accept(this)!!

        comp.isLocallyConsistent = Optional.of(false)
        return null
    }

    private fun addOrGet(sys: System): System {

        for (comp in components) {
            if (comp.sameAs(sys)) {
                return comp
            }
        }

        for (child in sys.children) {
            child.parents.add(sys)
        }

        components.add(sys)
        return sys
    }

}