package proofs

import parsing.Component
import parsing.Composition
import parsing.System
import java.util.*

class ConsistentCompositions : Proof {
    override fun search(component: System, ctx: ProofSearcher.IterationContext) {
        if (component.isLocallyConsistent.isEmpty && component is Composition){
            if (component.children.all { c -> c.isKnownLocallyConsistent() }) {
                component.isLocallyConsistent = Optional.of(true)
                ctx.setDirty(component)
            }else if (component.children.any {c -> c.isKnownNotLocallyConsistent()}){
                component.isLocallyConsistent = Optional.of(false)
                ctx.setDirty(component)
            }
        }else if (component.isKnownLocallyConsistent() && component is Composition){
            for (child in component.children){
                if (child.isLocallyConsistent.isEmpty){
                    child.isLocallyConsistent = Optional.of(true)
                    ctx.setDirty(child)
                }
            }
        }
    }
}