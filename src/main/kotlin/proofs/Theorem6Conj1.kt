package proofs

import parsing.Component
import parsing.Conjunction
import parsing.System

class Theorem6Conj1 : Proof {
    override fun search(component: System, ctx: ProofSearcher.IterationContext) {
        //TODO: we cant currently apply this to compositions because the ConsistentCompositions adds too many
        if(component !is Component) return

        if (component.isLocallyConsistent.orElse(false)){
            for (other in ctx.dirtyComponents) {
                if (other.isLocallyConsistent.orElse(false)){
                    if (other !is Component || component == other || component.inputs != other.inputs || component.outputs != other.outputs){
                        continue
                    }

                    val conj = ctx.addNewComponent(Conjunction(component, other))
                    //println("Conj: $conj")
                    conj.refines(other)
                    conj.refines(component)
                }
            }
        }
    }
}