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


    fun validateInputWiningNumber(input: String) {
        require(input.isNotEmpty()) { INPUT_EMPTY.message }
        require(input.length > 3) { MIN_SIX.message }
        require(input.contains(",")) { ONLY_COMMA.message }
        val nums = input.split(",").map { it.trim() }.map {
            try {
                it.toInt()
            } catch (e: IllegalArgumentException) {
                throw IllegalArgumentException(ONLY_NUMBER.message)
            }
        }
        require(nums.size == 6) { MIN_SIX.message }
        require(nums.all { it in 1..45 }) { NOT_1_BETWEEN_45.message }
    }

    fun validateBonusNumber(input: String) {
        require(input.isNotEmpty()) { INPUT_EMPTY.message }
        require(input.length < 3) { ONLY_ONE_BONUS_NUMBER.message }
        require(input.all { it.isDigit() }) { ONLY_NUMBER.message }
        require(input.toInt() in 1..45) { NOT_1_BETWEEN_45.message }
    }


}