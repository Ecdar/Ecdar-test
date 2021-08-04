package parsing

import javax.xml.parsers.*;
import facts.RelationLoader.prefixMap
import facts.RelationLoader.getInputs
import facts.RelationLoader.getOutputs
import java.io.File
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

interface System {

    var children: HashSet<System>
    var refinesThis: HashSet<System>
    var thisRefines: HashSet<System>
    var notRefinesThis: HashSet<System>
    var thisNotRefines: HashSet<System>
    var parents: HashSet<System>
    val depth: Int
    var isLocallyConsistent: Optional<Boolean>
    var inputs: HashSet<String>
    var outputs: HashSet<String>

    fun sameAs(other: System): Boolean

    fun refines(spec: System): Boolean {
        return thisRefines.add(spec) or
                spec.refinesThis.add(this)
    }

    fun notRefines(spec: System): Boolean {
        return thisNotRefines.add(spec) or spec.notRefinesThis.add(this)
    }

    override fun toString(): String
}

class Component(val prefix: String, val comp: String) : System {
    override var inputs = getInputs(prefix, comp)
    override var outputs = getOutputs(prefix, comp)
    init {
        assert(prefix in prefixMap) { "Unknown prefix $prefix for component $comp" }
    }

    override var children = HashSet<System>()
    override var refinesThis = HashSet<System>()
    override var thisRefines = HashSet<System>()
    override var notRefinesThis = HashSet<System>()
    override var thisNotRefines = HashSet<System>()
    override var parents = HashSet<System>()
    override val depth: Int
        get() = 0
    override var isLocallyConsistent: Optional<Boolean> = Optional.empty()


    override fun sameAs(other: System): Boolean {
        if (other is Component) {
            return prefix == other.prefix && comp == other.comp
        }
        return false
    }

    override fun toString(): String {
        return "$prefix.$comp"
    }

}

class Conjunction : System {
    constructor(left: System, right: System) {
        if (left is Conjunction) {
            children.addAll(left.children)
        } else {
            children.add(left)
        }
        if (right is Conjunction) {
            children.addAll(right.children)
        } else {
            children.add(right)
        }
        assert(children.size > 1)

        setActions()
    }

    constructor(children: HashSet<System>) {
        assert(children.size > 1)
        for (child in children) {
            if (child is Conjunction) {
                this.children.addAll(child.children)
            } else {
                this.children.add(child)
            }
        }

        setActions()
    }

    private fun setActions() {
        var first = true
        for (child in children) {
            if (first) {
                inputs.addAll(child.inputs)
                outputs.addAll(child.outputs)
                first = false
                continue
            }

            inputs = inputs.intersect(child.inputs).toHashSet()
            outputs = outputs.intersect(child.outputs).toHashSet()
        }
    }



    override var inputs = HashSet<String>()
    override var outputs = HashSet<String>()
    override var children = HashSet<System>()
    override var refinesThis = HashSet<System>()
    override var thisRefines = HashSet<System>()
    override var notRefinesThis = HashSet<System>()
    override var thisNotRefines = HashSet<System>()
    override var parents = HashSet<System>()
    override val depth: Int
        get() = 1 + (this.children.map { it.depth }.max() ?: 0)
    override var isLocallyConsistent: Optional<Boolean> = Optional.empty()


    override fun sameAs(other: System): Boolean {
        if (other is Conjunction) {
            return children == other.children
        }
        return false
    }


    override fun toString(): String {
        return "(${
            children.toArray().sortedWith(
                compareBy(String.CASE_INSENSITIVE_ORDER) { it.toString() }
            ).joinToString(" && ")
        })"
    }


}

class Composition : System {
    constructor(left: System, right: System) {
        if (left is Composition) {
            children.addAll(left.children)
        } else {
            children.add(left)
        }
        if (right is Composition) {
            children.addAll(right.children)
        } else {
            children.add(right)
        }
        assert(children.size > 1)

        setActions()
    }

    constructor(children: HashSet<System>) {
        assert(children.size > 1)
        for (child in children) {
            if (child is Composition) {
                this.children.addAll(child.children)
            } else {
                this.children.add(child)
            }
        }

        setActions()
    }

    private fun setActions() {
        for (child in children) {
            outputs.addAll(child.outputs)

            val potentialInputs = child.outputs.toHashSet()
            for (other in children) {
                if (other == child) continue
                potentialInputs.removeAll(other.outputs)
            }
        }
    }

    override var inputs = HashSet<String>()
    override var outputs = HashSet<String>()
    override var children = HashSet<System>()
    override var refinesThis = HashSet<System>()
    override var thisRefines = HashSet<System>()
    override var notRefinesThis = HashSet<System>()
    override var thisNotRefines = HashSet<System>()
    override var parents = HashSet<System>()
    override val depth: Int
        get() = 1 + (this.children.map { it.depth }.max() ?: 0)
    override var isLocallyConsistent: Optional<Boolean> = Optional.empty()


    override fun sameAs(other: System): Boolean {
        if (other is Composition) {
            return children == other.children
        }
        return false
    }

    override fun toString(): String {
        return "(${
            children.toArray().sortedWith(
                compareBy(String.CASE_INSENSITIVE_ORDER) { it.toString() }
            ).joinToString(" || ")
        })"
    }

}