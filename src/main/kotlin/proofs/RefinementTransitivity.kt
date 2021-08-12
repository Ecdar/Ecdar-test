package proofs

import ProofSearcher
import parsing.System

class RefinementTransitivity : Proof {
    override fun search(component: System, ctx: ProofSearcher.IterationContext) {
        for (lhs in component.refinesThis) {
            for (rhs in component.thisRefines) {
                if (lhs.refines(rhs)) {
                    ctx.setDirty(lhs)
                    ctx.setDirty(rhs)
                }
            }
        }
    }
}