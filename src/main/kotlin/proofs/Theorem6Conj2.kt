package proofs

import parsing.Conjunction
import parsing.System

class Theorem6Conj2: Proof {
    //HSCC.Theorem6.part2, locally consistent S, U and T: (U <= S) and (U <= T) implies U <= (S && T)
    override fun search(component: System, ctx: ProofSearcher.IterationContext) {
        if (component.thisRefines.size > 1) {
            val refines = HashSet<System>()
            refines.addAll(component.thisRefines)
            for (lhs in refines) {
                for (rhs in refines) {
                    if (!lhs.sameAs(rhs)){
                        var newComp : System = Conjunction(lhs, rhs)
                        newComp = ctx.addNewComponent(newComp)
                        if(newComp.refinesThis.add(component)) {
                            ctx.setDirty(newComp)
                        }
                        if(component.thisRefines.add(newComp)) {
                            ctx.setDirty(component)
                        }
                    }
                }
            }

        }

    }
}
