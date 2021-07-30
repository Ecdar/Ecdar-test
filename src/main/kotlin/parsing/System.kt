package parsing

import facts.RelationLoader.prefixMap

interface System {
    val refinesThis: HashSet<System>
    val thisRefines: HashSet<System>
    val notRefinesThis: HashSet<System>
    val thisNotRefines: HashSet<System>

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

    var rt = HashSet<System>()
    var tr = HashSet<System>()
    var nrt = HashSet<System>()
    var tnr = HashSet<System>()
    override val refinesThis: HashSet<System>
        get() = rt
    override val thisRefines: HashSet<System>
        get() = tr
    override val notRefinesThis: HashSet<System>
        get() = nrt
    override val thisNotRefines: HashSet<System>
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

class Conjunction : System {
    var children = HashSet<System>()
    constructor(left: System, right: System) {
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

    constructor(children: HashSet<System>){
        this.children = children
    }

    var rt = HashSet<System>()
    var tr = HashSet<System>()
    var nrt = HashSet<System>()
    var tnr = HashSet<System>()
    override val refinesThis: HashSet<System>
        get() = rt
    override val thisRefines: HashSet<System>
        get() = tr
    override val notRefinesThis: HashSet<System>
        get() = nrt
    override val thisNotRefines: HashSet<System>
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
}

class Composition : System {
    var children = HashSet<System>()

    constructor(left: System, right: System) {
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

    constructor(children: HashSet<System>){
        this.children = children
    }

    var rt = HashSet<System>()
    var tr = HashSet<System>()
    var nrt = HashSet<System>()
    var tnr = HashSet<System>()
    override val refinesThis: HashSet<System>
        get() = rt
    override val thisRefines: HashSet<System>
        get() = tr
    override val notRefinesThis: HashSet<System>
        get() = nrt
    override val thisNotRefines: HashSet<System>
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


}