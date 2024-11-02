package lotto.model

import lotto.constants.Constants
import lotto.constants.ErrorMessage
import lotto.utils.Validator

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == Constants.LOTTO_SIZE) { ErrorMessage.LOTTO_COUNT_ERROR }
        require(Validator.isDuplicatedNumbers(numbers)) { ErrorMessage.DUPLICATED_NUMBER }
    }

    fun getNumbers() = numbers
}
