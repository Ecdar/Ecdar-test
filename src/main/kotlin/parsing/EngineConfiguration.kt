package parsing

import com.beust.klaxon.Json
import com.beust.klaxon.Klaxon
import java.io.File

fun parseEngineConfigurations(): List<EngineConfiguration> {
    return Klaxon().parseArray(File("configuration.json"))!!
}

data class EngineConfiguration(
    val name: String,
    @Json(name = "executablePath")
    val path: String,
    @Json(name = "parameterExpression")
    val parameterExpression: String
) {
    fun getCommand(folder: String, query: String): String {
        return "$path ${parameterExpression.replace("{input}", folder).replace("{query}", query)}"
    }
}


