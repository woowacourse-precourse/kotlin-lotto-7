package util

enum class Exception(private val msg: String) {
    EMPTY_INPUT("빈 값이 입력 되었어요.");


    override fun toString(): String = "$ERROR $msg"

    companion object {
        private const val ERROR = "[ERROR]"
    }
}