import analytics.ProofAnalytic
import parsing.System
import proofs.Proof
import proofs.RefinementTransitivity
import proofs.SelfRefinement
import proofs.Theorem6Conj2

class ProofSearcher {
    private val theorems = ArrayList<Proof>()
    private val analytics = ArrayList<ProofAnalytic>()

    fun addProof(proof: Proof): ProofSearcher{
        if (!theorems.contains(proof)){
            theorems.add(proof)
        }

        return this
    }

    fun addAnalytic(analytic: ProofAnalytic): ProofSearcher{
        analytics.add(analytic)
        return this
    }

    fun findNewRelations(components: ArrayList<System>): ArrayList<System> {
        analytics.forEach{analytic -> analytic.recordStart(components)}

        val result = runSearch(components)

        analytics.forEach{analytic -> analytic.recordEnd(components)}

        return result
    }

    private fun runSearch(components: ArrayList<System>): ArrayList<System> {
        val allComponents = ArrayList<System>(components)
        var dirtyComponents = HashSet(components)

        var iteration = 0

        while (dirtyComponents.isNotEmpty()) {

            val line = "Dirty components/components: ${dirtyComponents.count()}/${allComponents.count()} it: $iteration"
            println(line)
            dirtyComponents = searchIteration(dirtyComponents, allComponents)

            analytics.forEach{analytic -> analytic.recordIteration(dirtyComponents, allComponents)}
            iteration++
        }

        return allComponents
    }

    private fun searchIteration(
        dirty_components: HashSet<System>,
        all_components: ArrayList<System>
    ): HashSet<System> {
        val context = IterationContext(all_components, dirty_components)
        for (theorem in theorems){
            for (comp in dirty_components) {
                theorem.search(comp, context)
            }
            analytics.forEach{analytic -> analytic.recordProofIteration(dirty_components, all_components, theorem)}
        }

        return context.newlyMarkedComponents
    }

    class IterationContext(val components: ArrayList<System>, val dirtyComponents: HashSet<System>) {
        var newlyMarkedComponents = HashSet<System>()

        fun setDirty(component: System) {
            newlyMarkedComponents.add(component)
        }

        fun addNewComponent(component: System) : System {
            for (comp in components) {
                if (comp.sameAs(component)) {
                    return comp
                }
            }

            for (child in component.children) {
                child.parents.add(component)
                newlyMarkedComponents.add(child)
            }

            components.add(component)
            newlyMarkedComponents.add(component)
            return component
        }
    }

}