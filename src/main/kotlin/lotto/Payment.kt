package lotto

class Payment(private val payment: String) {

    init {
        require(isNumber()) { "$ERROR $NOT_NUMBER_MESSAGE" }
        require(isNegativeAndZeroNumber()) {"$ERROR $MORE_THAN_ZERO"}
        require(isLottoUnit()) {"$ERROR $NOT_LOTTO_UNIT"}
    }

    private fun isLottoUnit() = payment.toInt() % LOTTO_UNIT == LOTTO_CHANGE

    private fun isNegativeAndZeroNumber() = payment.toInt() > NEGATIVE_AND_ZERO

    private fun isNumber() = payment.toIntOrNull() != null

    companion object {
        const val NEGATIVE_AND_ZERO = 0
        const val LOTTO_CHANGE = 0
        const val LOTTO_UNIT = 1000

        const val ERROR = "[ERROR]"
        const val NOT_NUMBER_MESSAGE = "숫자만 입력해주세요."
        const val MORE_THAN_ZERO = "구입 금액이 0보다 작을 수 없습니다."
        const val NOT_LOTTO_UNIT = "1000원 단위로 입력해주세요."
    }
}