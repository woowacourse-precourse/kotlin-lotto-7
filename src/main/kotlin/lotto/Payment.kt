package lotto

class Payment(private val payment: String) {

    init {
        require(isNumber()) { "$ERROR $NOT_NUMBER_MESSAGE" }

    }

    private fun isNumber() = payment.toIntOrNull() != null

    companion object {
        const val ERROR = "[ERROR]"
        const val NOT_NUMBER_MESSAGE = "숫자만 입력해주세요"
    }
}