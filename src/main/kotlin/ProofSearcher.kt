import parsing.System
import proofs.Proof
import proofs.RefinementTransitivity
import proofs.SelfRefinement
import proofs.Theorem6Conj2

class ProofSearcher {
    private val theorems: Array<Proof> = arrayOf(
        RefinementTransitivity(),
        SelfRefinement(),
        Theorem6Conj2()
    )

    fun findNewRelations(components: ArrayList<System>): ArrayList<System> {
        val allComponents = ArrayList<System>(components)
        var dirtyComponents = HashSet(components)

        while (dirtyComponents.isNotEmpty()) {
            dirtyComponents = searchIteration(dirtyComponents, allComponents)
        }

        return allComponents
    }

    private fun searchIteration(
        dirty_components: HashSet<System>,
        all_components: ArrayList<System>
    ): HashSet<System> {
        val context = IterationContext(all_components)
        for (comp in dirty_components) {

            for (theorem in theorems) {
                theorem.search(comp, context)
            }
        }

        return context.newlyMarkedComponents
    }

    class IterationContext(components: ArrayList<System>) {
        var components = components
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
            components.add(component)
            newlyMarkedComponents.add(component)
            return component
        }
    }

}