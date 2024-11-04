package lotto.domain

import lotto.constant.ExceptionMessage.ERROR_DUPLICATE_NUMBER
import lotto.constant.ExceptionMessage.ERROR_NOT_ITEM_LENGTH
import lotto.constant.ExceptionMessage.ERROR_NOT_LOTTO_NUMBER
import lotto.constant.LottoRule

class LottoWinningInfo(val numbers: List<Int>) {
    var bonusNumber: Int? = null
        set(value) {
            validateNumberRange(value!!)
            require(!numbers.contains(value)) { ERROR_DUPLICATE_NUMBER }
            field = value
        }

    init {
        validateLottoNumberSize(numbers)
        for (number in numbers) {
            validateNumberRange(number)
        }
        validateDuplicates(numbers)
    }

    private fun validateLottoNumberSize(numbers: List<Int>) {
        require(numbers.size == LottoRule.ITEM_LENGTH) { ERROR_NOT_ITEM_LENGTH }
    }

    private fun validateNumberRange(number: Int) {
        require(number in LottoRule.START_NUMBER..LottoRule.END_NUMBER) { ERROR_NOT_LOTTO_NUMBER }
    }

    private fun validateDuplicates(numbers: List<Int>) {
        val filterNumbers = numbers.toMutableSet()
        require(filterNumbers.size == LottoRule.ITEM_LENGTH) { ERROR_DUPLICATE_NUMBER }
    }
}
