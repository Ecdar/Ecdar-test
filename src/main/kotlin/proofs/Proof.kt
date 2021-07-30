package proofs

import parsing.System
import ProofSearcher.IterationContext;

interface Proof {
    fun search(component: System, ctx: IterationContext)
}