package tests

import parsing.System
import java.lang.Exception

class GeneratedComponentTest(val system: System, private val base: Test) : Test(
    system.getProjectFolder(),
    "get-component: ${system.getName()} save-as TempComponent;${base.query}"
) {
    init {
        if (this.projectPath != base.projectPath){
            throw Exception("A generated component test has to be saved into the same project as its used in")
        }
        else if (this.projectPath.endsWith(".xml")){
            throw Exception("Generated components are not supported with xml projects")
        }
    }

    override fun getResult(stdout: String): Boolean? {
        //This only works on tests that look at the end of the output from the model checking engine due to multiple queries
        return base.getResult(stdout)
    }
}