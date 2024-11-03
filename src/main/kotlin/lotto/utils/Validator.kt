package lotto.utils

import lotto.enums.Error.*

class Validator {
    fun validateInputAmount(input: String) {
        require(input.isNotEmpty()) { INPUT_EMPTY.message }

        val amount = input.toIntOrNull() ?: throw error(ONLY_NUMBER.message)

        require(amount % 1000 == 0) { NOT_MULTIPLE_OF_1000.message }
    }
}