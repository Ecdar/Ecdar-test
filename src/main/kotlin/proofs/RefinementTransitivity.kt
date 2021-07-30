package proofs
import parsing.System

class RefinementTransitivity: Proof {
    override fun search(component: System, ctx: ProofSearcher.IterationContext) {
        for (lhs in component.refinesThis){
            for (rhs in component.thisRefines){
                if (!lhs.thisRefines.contains(rhs)) {
                    lhs.thisRefines.add(rhs)
                    rhs.refinesThis.add(lhs)

                    ctx.setDirty(lhs)
                    ctx.setDirty(rhs)
                }
            }
        }
    }
}