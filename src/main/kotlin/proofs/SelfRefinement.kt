package proofs

import parsing.System

class SelfRefinement : Proof {
    override fun search(component: System, ctx: ProofSearcher.IterationContext) {
        if (!component.refinesThis.contains(component) && component.isLocallyConsistent.orElse(false)) {
            component.refines(component)

            ctx.setDirty(component)
        }
    }
}