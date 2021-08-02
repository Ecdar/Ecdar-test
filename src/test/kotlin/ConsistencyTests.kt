import facts.RelationLoader
import parsing.RelationParserFacade
import parsing.RelationVisitor
import java.io.File
import kotlin.test.Test
import kotlin.test.assertTrue
import parsing.System

internal class ConsistencyTests {

    @Test
    fun consistentComponents() {
        var consistencyCount = consistencyCount(RelationLoader.relations);
        println("Consistent: " + consistencyCount)

        assert(consistencyCount == 10)
    }

    @Test
    fun inconsistentComponents() {
        var nonConsistencyCount = nonConsistencyCount(RelationLoader.relations);
        println("Consistent: " + nonConsistencyCount)

        assert(nonConsistencyCount == 11)
    }

    fun consistencyCount(components: ArrayList<System>): Int{
        var count = 0
        for (comp in components) {
            if (comp.isLocallyConsistent.orElse(false)){
                count++
            }
        }

        return count
    }
    fun nonConsistencyCount(components: ArrayList<System>): Int{
        var count = 0
        for (comp in components) {
            if (!comp.isLocallyConsistent.orElse(true)){
                count++
            }
        }

        return count
    }
}