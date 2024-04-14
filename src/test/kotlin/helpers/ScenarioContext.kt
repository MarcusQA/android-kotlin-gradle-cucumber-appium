package helpers

class ScenarioContext {
    private val contextMap: MutableMap<String, Any>

    init {
        contextMap = HashMap()
    }

    fun setContext(key: String, value: Any) {
        contextMap[key] = value
    }

    fun getContext(key: String): Any? {
        return contextMap[key]
    }
}