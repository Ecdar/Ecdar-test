package proofs

import ProofSearcher.IterationContext
import parsing.System

interface Proof {
    fun search(component: System, ctx: IterationContext)
}