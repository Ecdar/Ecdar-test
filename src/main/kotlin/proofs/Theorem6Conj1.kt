package proofs

import ProofSearcher
import parsing.Component
import parsing.Conjunction
import parsing.System

class Theorem6Conj1 : Proof {
    override fun search(component: System, ctx: ProofSearcher.IterationContext) {
        //TODO: we cant currently apply this to compositions because the ConsistentCompositions adds too many
        if (component !is Component) return

        if (component.isKnownLocallyConsistent()) {
            for (other in ctx.dirtyComponents) {
                if (other.isKnownLocallyConsistent()) {
                    if (other !is Component || component == other || component.inputs != other.inputs || component.outputs != other.outputs || component.getProjectFolder() != other.getProjectFolder()) {
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