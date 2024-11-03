package lotto

class Payment(private val payment: String) {

    init {
        require(isNumber()) { "$ERROR $NOT_NUMBER_MESSAGE" }
        require(isNegativeAndZeroNumber()) {"$ERROR $MORE_THAN_ZERO"}
    }

    private fun isNegativeAndZeroNumber() = payment.toInt() <= NEGATIVE_AND_ZERO

    private fun isNumber() = payment.toIntOrNull() != null

    companion object {
        const val NEGATIVE_AND_ZERO = 0

        const val ERROR = "[ERROR]"
        const val NOT_NUMBER_MESSAGE = "숫자만 입력해주세요"
        const val MORE_THAN_ZERO = "구입 금액이 0보다 작을 수 없습니다."
    }
}