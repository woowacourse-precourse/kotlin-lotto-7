package util

enum class Exception(private val msg: String) {
    EMPTY_INPUT("빈 값이 입력 되었어요."),
    INVALID_INPUT("숫자만 입력해주세요."),
    EXCEED_INPUT("번호의 숫자 범위는 1~45까지 입니다.");

    override fun toString(): String = "$ERROR $msg"

    companion object {
        private const val ERROR = "[ERROR]"
    }
}