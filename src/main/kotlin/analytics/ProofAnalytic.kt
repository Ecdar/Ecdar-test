package analytics
import parsing.System

interface ProofAnalytic {

    fun recordStart(components: ArrayList<System>){

    }

    fun recordEnd(components: ArrayList<System>){

    }

    fun recordIteration(dirtyComponents: HashSet<System>, components: ArrayList<System>){

    }

}