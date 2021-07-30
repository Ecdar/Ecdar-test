package parsing

import facts.RelationLoader.prefixMap

interface System {
    val refinesThis: ArrayList<System>
    val thisRefines: ArrayList<System>
    val notRefinesThis: ArrayList<System>
    val thisNotRefines: ArrayList<System>

    fun sameAs(other: System): Boolean

    fun refinesOther(other: System) {
        thisRefines.add(other)
    }
    fun notRefinesOther(other: System) {
        thisNotRefines.add(other)
    }

    fun otherRefines(other: System) {
        refinesThis.add(other)
    }

    fun otherNotRefines(other: System) {
        notRefinesThis.add(other)
    }

     override fun toString(): String
}

class Component(val prefix: String, val comp: String) : System {

    init {
        assert(prefix in prefixMap) { "Unknown prefix $prefix for component $comp" }
    }

    var rt = ArrayList<System>()
    var tr = ArrayList<System>()
    var nrt = ArrayList<System>()
    var tnr = ArrayList<System>()
    override val refinesThis: ArrayList<System>
        get() = rt
    override val thisRefines: ArrayList<System>
        get() = tr
    override val notRefinesThis: ArrayList<System>
        get() = nrt
    override val thisNotRefines: ArrayList<System>
        get() = tnr

    override fun sameAs(other: System): Boolean {
        if(other is Component) {
            return prefix == other.prefix && comp == other.comp
        }
        return false
    }

    override fun toString(): String {
        return "$prefix.$comp"
    }


}

class Conjunction(left: System, right: System) : System {
    var children = HashSet<System>()

    var rt = ArrayList<System>()
    var tr = ArrayList<System>()
    var nrt = ArrayList<System>()
    var tnr = ArrayList<System>()
    override val refinesThis: ArrayList<System>
        get() = rt
    override val thisRefines: ArrayList<System>
        get() = tr
    override val notRefinesThis: ArrayList<System>
        get() = nrt
    override val thisNotRefines: ArrayList<System>
        get() = tnr

    override fun sameAs(other: System): Boolean {
        if(other is Conjunction) {
            return children == other.children
        }
        return false
    }

    override fun toString(): String {
        return "(${children.joinToString(" && ")})"
    }

    init {
        if(left is Conjunction) {
            children.addAll(left.children)
        } else {
            children.add(left)
        }
        if(right is Conjunction) {
            children.addAll(right.children)
        } else {
            children.add(right)
        }
    }


}

class Composition(left: System, right: System) : System {
    var children = HashSet<System>()

    var rt = ArrayList<System>()
    var tr = ArrayList<System>()
    var nrt = ArrayList<System>()
    var tnr = ArrayList<System>()
    override val refinesThis: ArrayList<System>
        get() = rt
    override val thisRefines: ArrayList<System>
        get() = tr
    override val notRefinesThis: ArrayList<System>
        get() = nrt
    override val thisNotRefines: ArrayList<System>
        get() = tnr

    override fun sameAs(other: System): Boolean {
        if(other is Composition) {
            return children == other.children
        }
        return false
    }

    override fun toString(): String {
        return "(${children.joinToString(" || ")})"
    }

    init {
        if(left is Composition) {
            children.addAll(left.children)
        } else {
            children.add(left)
        }
        if(right is Composition) {
            children.addAll(right.children)
        } else {
            children.add(right)
        }
    }
}