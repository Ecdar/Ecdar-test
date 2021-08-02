package proofs

import parsing.Composition
import parsing.System
import java.util.*

class ConsistentRefinements : Proof {
    override fun search(component: System, ctx: ProofSearcher.IterationContext) {
        if (component.refinesThis.count() > 0 || component.thisRefines.count() > 0) {
            if (!component.isLocallyConsistent.orElse(false)){
                component.isLocallyConsistent = Optional.of(true)
                ctx.setDirty(component)
            }
        }
    }
}