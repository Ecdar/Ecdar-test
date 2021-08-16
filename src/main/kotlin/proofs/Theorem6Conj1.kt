package proofs

import ProofSearcher
import parsing.Component
import parsing.Conjunction
import parsing.System

class Theorem6Conj1 : Proof {
    override fun search(component: System, ctx: ProofSearcher.IterationContext) {
        //TODO: we cant currently apply this to compositions because the ConsistentCompositions adds too many
        if (component !is Component) return

        if (component.isKnownLocallyConsistent()) {
            for (other in ctx.dirtyComponents) {
                if (other !is Component || component == other)
                    continue

                if (other.isKnownLocallyConsistent() && component.sharesAlphabet(other)) {
                    addNewConjunction(ctx, component, other)
                }
            }
        }
    }

    private fun addNewConjunction(ctx: ProofSearcher.IterationContext, component: System, other: System) {
        val conj = ctx.addNewComponent(Conjunction(component, other))

        if (conj.isKnownLocallyConsistent()) { //This if might be wrong and is waiting for confirmation by Martijn -> https://discord.com/channels/812704528175464458/836933691769880616/875454428608606318
            setParentRefinesChildren(conj, ctx)
        }
    }

    private fun setParentRefinesChildren(
        parent: System,
        ctx: ProofSearcher.IterationContext
    ) {
        for (child in parent.children){
            if (parent.refines(child)){
                ctx.setDirty(child)
            }
        }
    }
}