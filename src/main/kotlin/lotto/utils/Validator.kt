package lotto.utils

import lotto.enums.Error.*

class Validator {
    fun validateInputAmount(input: String) {
        require(input.isNotEmpty()) { INPUT_EMPTY.message }

        require(input.all { it.isDigit() }) { ONLY_NUMBER.message }

        val amount = input.toInt()

        require(amount != 0) { NOT_MULTIPLE_OF_1000.message }

        require(amount % 1000 == 0) { NOT_MULTIPLE_OF_1000.message }
    }
}