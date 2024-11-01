package lotto.domain

import lotto.constant.ExceptionMessage.ERROR_DUPLICATE_NUMBER
import lotto.constant.ExceptionMessage.ERROR_NOT_ITEM_LENGTH
import lotto.constant.ExceptionMessage.ERROR_NOT_LOTTO_NUMBER

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
        require(numbers.size == Lotto.ITEM_LENGTH) { ERROR_NOT_ITEM_LENGTH }
    }

    private fun validateNumberRange(number: Int) {
        require(number in Lotto.START_NUMBER..Lotto.END_NUMBER) { ERROR_NOT_LOTTO_NUMBER }
    }

    private fun validateDuplicates(numbers: List<Int>) {
        val filterNumbers = numbers.toMutableSet()
        require(filterNumbers.size == Lotto.ITEM_LENGTH) { ERROR_DUPLICATE_NUMBER }
    }
}
