package lotto.validator

import lotto.constant.*

class InputValidator {

    fun isValidMoney(input: String) {
        val regex = Regex(MONEY_REGEX)
        val money = input.replace(COMMA, "").toIntOrNull()

        if (input == "") {
            throw IllegalArgumentException(ValidatorMessage.INVALID_INPUT.message)
        } else if (!regex.matches(input)) {
            throw IllegalArgumentException(ValidatorMessage.INVALID_INPUT.message)
        } else if (money == null) {
            throw IllegalArgumentException(ValidatorMessage.INVALID_INPUT.message)
        } else if (money % AMOUNT_UNIT != 0 || money <= 0) {
            throw IllegalArgumentException(ValidatorMessage.INVALID_INPUT.message)
        }
    }

    fun isValidWinningNum(input: String) {
        val inputNumbers = input.split(COMMA).map { it.trim() }

        if (input == "") {
            throw IllegalArgumentException(ValidatorMessage.INVALID_INPUT.message)
        } else if (inputNumbers.size != LOTTO_SIZE) {
            throw IllegalArgumentException(ValidatorMessage.INVALID_COUNT_NUM.message)
        } else if (inputNumbers.size != inputNumbers.distinct().size) {
            throw IllegalArgumentException(ValidatorMessage.DUPLICATE_NUM.message)
        }
        inputNumbers.forEach {
            val num = it.toIntOrNull()
            if (num == null || num < MIN_LOTTO_NUM || num > MAX_LOTTO_NUM) {
                throw IllegalArgumentException(ValidatorMessage.INVALID_RANGE_NUM.message)
            }
        }
    }

    fun isValidBonusNum(input: String, winningNum: List<Int>) {
        val num = input.toIntOrNull()

        if (num == null || num < MIN_LOTTO_NUM || num > MAX_LOTTO_NUM) {
            throw IllegalArgumentException(ValidatorMessage.INVALID_RANGE_NUM.message)
        } else if (winningNum.contains(num)) {
            throw IllegalArgumentException(ValidatorMessage.DUPLICATE_NUM.message)
        }
    }
}
