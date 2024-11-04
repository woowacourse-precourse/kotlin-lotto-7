package lotto.data

import lotto.utils.Random

class Client(private val amount: String) {

    val lottoNumbers: List<List<Int>>
    private val lotto: List<Lotto>

    init {
        require(amount.isNotEmpty()) { AMOUNT_EMPTY_ERROR_MESSAGE }
        require(amount.all { it.isDigit() }) { AMOUNT_NOT_ALL_NUMBER_ERROR_MESSAGE }
        require(amount.toIntOrNull() != null) { AMOUNT_RANGE_ERROR_MESSAGE }
        require(amount.toInt() % AMOUNT_UNIT == EXPECTED_RESULT) { AMOUNT_UNIT_ERROR_MESSAGE }
        require(amount.toInt() in AMOUNT_UNIT..AMOUNT_MAX_VALUE) { AMOUNT_RANGE_ERROR_MESSAGE }
        require(amount.first() in AMOUNT_START_MIN_VALUE..AMOUNT_START_MAX_VALUE) { AMOUNT_FORMAT_ERROR_MESSAGE }
        lottoNumbers = createLottoNumbers(amount)
        lotto = lottoNumbers.toLotto()
    }

    companion object {
        private const val AMOUNT_EMPTY_ERROR_MESSAGE = "[ERROR] 구입 금액이 입력되지 않았습니다. 구입 금액을 입력해주세요."
        private const val AMOUNT_NOT_ALL_NUMBER_ERROR_MESSAGE = "[ERROR] 숫자로만 입력해주세요."
        private const val AMOUNT_FORMAT_ERROR_MESSAGE = "[ERROR] 10000 과 같은 형태로 입력해주세요."
        private const val AMOUNT_UNIT_ERROR_MESSAGE = "[ERROR] 1,000원 단위로만 구매 가능합니다."
        private const val AMOUNT_RANGE_ERROR_MESSAGE = "[ERROR] 1,000원 ~ 100,000원 이내로만 구매 가능합니다."
        private const val AMOUNT_START_MIN_VALUE = '1'
        private const val AMOUNT_START_MAX_VALUE = '9'
        private const val AMOUNT_UNIT = 1_000
        private const val EXPECTED_RESULT = 0
        private const val AMOUNT_MAX_VALUE = 100_000

        private fun createLottoNumbers(amount: String) =
            List(amount.toInt() / AMOUNT_UNIT) { Random.crateLottoNumbers() }

        private fun List<List<Int>>.toLotto() = this.map { Lotto(it) }
    }
}