package proofs

import ProofSearcher

fun ProofSearcher.addAllProofs() : ProofSearcher{
    return this.addRefinementProofs()
}

fun ProofSearcher.addRefinementProofs() : ProofSearcher {
    return this.addProof(RefinementTransitivity())
        .addProof(SelfRefinement())
        .addProof(Theorem6Conj2())
}