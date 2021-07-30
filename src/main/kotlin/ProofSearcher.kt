import parsing.System
import proofs.Proof
import proofs.RefinementTransitivity

class ProofSearcher  {
    private val theorems: Array<Proof> = Array(1){RefinementTransitivity()}

    fun findNewRelations(components: ArrayList<System>): ArrayList<System> {
        var allComponents = ArrayList<System>(components)
        var dirtyComponents = components

       while( dirtyComponents.isNotEmpty() ){
           dirtyComponents = searchIteration(dirtyComponents, allComponents)
       }

        return allComponents
    }

    private fun searchIteration(dirty_components: ArrayList<System>, all_components: ArrayList<System>): ArrayList<System> {
        var context = IterationContext(all_components)
println("Iteration")

        for (comp in dirty_components) {
            for (theorem in theorems) {
                theorem.search(comp, context)
            }
        }

        return context.newlyMarkedComponents
    }

    class IterationContext(components: ArrayList<System>) {
        var components = components
        var newlyMarkedComponents = ArrayList<System>()

        fun set_dirty(component: System) {
            newlyMarkedComponents.add(component)
        }

        fun add_new_component(component: System) {
            components.add(component)
            newlyMarkedComponents.add(component)
        }
    }

}