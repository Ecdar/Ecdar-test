import tests.Test

class TestResult(
    val test: Test,
    val result: String,
    val engineOutput: String
) {
    val timestamp = System.currentTimeMillis() / 1000
    var engine: String? = null
}

