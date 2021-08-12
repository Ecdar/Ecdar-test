package proofs

import parsing.System

class SelfRefinement : Proof {
    override fun search(component: System, ctx: ProofSearcher.IterationContext) {
        if (component.isKnownLocallyConsistent()) {
            if (component.refines(component)){
                ctx.setDirty(component)
            }
        }
    }
}