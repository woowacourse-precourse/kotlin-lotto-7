package lotto.data

class LottoAmount(private val amount: String) {
    init {
        require(amount.toIntOrNull() != null) { AMOUNT_FORMAT_ERROR_MESSAGE }
        require(amount.first() in AMOUNT_START_MIN_VALUE..AMOUNT_START_MAX_VALUE) { AMOUNT_FORMAT_ERROR_MESSAGE }
        require(amount.toInt() % AMOUNT_UNIT == EXPECTED_RESULT) { AMOUNT_UNIT_ERROR_MESSAGE }
        require(amount.toInt() in AMOUNT_UNIT..AMOUNT_MAX_VALUE) { AMOUNT_RANGE_ERROR_MESSAGE }
    }

    companion object {
        private const val AMOUNT_FORMAT_ERROR_MESSAGE = "[ERROR] 1000, 35000 과 같이 숫자로만 입력해주세요."
        private const val AMOUNT_UNIT_ERROR_MESSAGE = "[ERROR] 1,000원 단위로만 구매 가능합니다."
        private const val AMOUNT_RANGE_ERROR_MESSAGE = "[ERROR] 1,000원 ~ 100,000원 이내로만 구매 가능합니다."
        private const val AMOUNT_START_MIN_VALUE = '1'
        private const val AMOUNT_START_MAX_VALUE = '9'
        private const val AMOUNT_UNIT = 1_000
        private const val EXPECTED_RESULT = 0
        private const val AMOUNT_MAX_VALUE = 100_000
    }
}