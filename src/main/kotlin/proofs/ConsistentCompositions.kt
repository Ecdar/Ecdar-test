package proofs

import parsing.Component
import parsing.Composition
import parsing.System
import java.util.*

class ConsistentCompositions : Proof {
    override fun search(component: System, ctx: ProofSearcher.IterationContext) {
        if (component.isLocallyConsistent.orElse(false) && component is Component){

            for (other in ctx.dirtyComponents) {
                if (other.isLocallyConsistent.orElse(false) && other is Component){
                    if (component.prefix != other.prefix){
                        //Only allow compositions from components from the same project
                        continue
                    }

                    val comp = ctx.addNewComponent(Composition(component, other))

                    if (comp.isLocallyConsistent.isEmpty){
                        comp.isLocallyConsistent = Optional.of(true)

                        ctx.setDirty(component)
                        ctx.setDirty(other)
                        ctx.setDirty(comp)
                    }

                }
            }
        }
    }
}