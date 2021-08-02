package proofs

import parsing.Component
import parsing.Composition
import parsing.System
import java.util.*

class ConsistentCompositions : Proof {
    override fun search(component: System, ctx: ProofSearcher.IterationContext) {
        if (component.isLocallyConsistent.isPresent && component is Component){

            for (other in ctx.dirtyComponents) {
                if (other.isLocallyConsistent.isPresent && other is Component){
                    if (component.prefix != other.prefix){
                        //Only allow compositions from components from the same project
                        continue;
                    }

                    val comp = ctx.addNewComponent(Composition(component, other))

                    if (comp.isLocallyConsistent.isEmpty){
                        val isConsistent = component.isLocallyConsistent.get() && other.isLocallyConsistent.get()
                        comp.isLocallyConsistent = Optional.of(isConsistent)

                        println("$component || $other  =  $comp")

                        ctx.setDirty(component)
                        ctx.setDirty(other)
                        ctx.setDirty(comp)
                    }

                }
            }
        }
    }
}