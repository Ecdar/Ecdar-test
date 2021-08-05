package proofs

import ProofSearcher

fun ProofSearcher.addAllProofs() : ProofSearcher{
    return this.addRefinementProofs()
        .addConsistencyProofs()
}

fun ProofSearcher.addRefinementProofs() : ProofSearcher {
    return this.addProof(RefinementTransitivity())
        .addProof(SelfRefinement())
        .addProof(Theorem6Conj2())
        .addProof(ConsistentRefinements())
        .addProof(Theorem6Conj1())
}

fun ProofSearcher.addConsistencyProofs() : ProofSearcher {
    return this.addProof(ConsistentRefinements())
        .addProof(ConsistentCompositions())
}