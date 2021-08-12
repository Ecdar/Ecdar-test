package proofs

import ProofSearcher
import parsing.System
import java.util.*

class ConsistentRefinements : Proof {
    override fun search(component: System, ctx: ProofSearcher.IterationContext) {
        if (component.refinesThis.isNotEmpty() || component.thisRefines.isNotEmpty()) {
            if (component.isLocallyConsistent.isEmpty) {
                component.isLocallyConsistent = Optional.of(true)
                ctx.setDirty(component)
            }
        }
    }
}