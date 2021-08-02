package parsing

import facts.RelationLoader.prefixMap

interface System {
    var children: HashSet<System>
    var refinesThis: HashSet<System>
    var thisRefines: HashSet<System>
    var notRefinesThis: HashSet<System>
    var thisNotRefines: HashSet<System>
    var parents: HashSet<System>
    val depth: Int

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

    override var children = HashSet<System>()
    override var refinesThis = HashSet<System>()
    override var thisRefines = HashSet<System>()
    override var notRefinesThis = HashSet<System>()
    override var thisNotRefines = HashSet<System>()
    override var parents = HashSet<System>()
    override val depth: Int
        get() = 0

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

    constructor(children: HashSet<System>) {
        for (child in children){
            if(child is Conjunction) {
                this.children.addAll(child.children)
            } else {
                this.children.add(child)
            }
        }
    }

    override var children = HashSet<System>()
    override var refinesThis = HashSet<System>()
    override var thisRefines = HashSet<System>()
    override var notRefinesThis = HashSet<System>()
    override var thisNotRefines = HashSet<System>()
    override var parents = HashSet<System>()
    override val depth: Int
        get() = 1 + (this.children.map { it.depth }.max()?: 0)

    override fun sameAs(other: System): Boolean {
        if(other is Conjunction) {
            return children == other.children
        }
        return false
    }


    override fun toString(): String {
        return "(${children.toArray().sortedWith(
            compareBy(String.CASE_INSENSITIVE_ORDER) { it.toString() }
        ).joinToString(" && ")})"
    }
}

class Composition : System {
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

    constructor(children: HashSet<System>) {
        for (child in children){
            if(child is Composition) {
                this.children.addAll(child.children)
            } else {
                this.children.add(child)
            }
        }
    }

    override var children = HashSet<System>()
    override var refinesThis = HashSet<System>()
    override var thisRefines = HashSet<System>()
    override var notRefinesThis = HashSet<System>()
    override var thisNotRefines = HashSet<System>()
    override var parents = HashSet<System>()
    override val depth: Int
        get() = 1 + (this.children.map { it.depth }.max()?: 0)

    override fun sameAs(other: System): Boolean {
        if(other is Composition) {
            return children == other.children
        }
        return false
    }

    override fun toString(): String {
        return "(${children.toArray().sortedWith(
            compareBy(String.CASE_INSENSITIVE_ORDER) { it.toString() }
        ).joinToString(" || ")})"
    }

}