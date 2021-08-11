package parsing

import com.beust.klaxon.Json

data class EngineConfiguration(
    @Json(name= "executablePath")
    val path: String,
    @Json(name= "parameterExpression")
    val parameterExpression: String
) {
    fun getCommand(folder:String, query:String) : String{
        return "$path ${parameterExpression.replace("{input}", folder).replace("{query}", query)}"
    }
}


