package lotto.utils

import lotto.constants.ErrorMessage

object Validation {
    fun isValidRange(vararg numbers: Int): Boolean = numbers.map { it in 1..45 }.all { it }

    fun isNotDuplicated(winningNumber: Set<Int>, bonusNumber: Int): Boolean = !winningNumber.contains(bonusNumber)
}

object Price {
    fun validate(inputPrice: String): Int {
        val price = inputPrice.toIntOrNull() ?: throw IllegalArgumentException(ErrorMessage.PARSE_NUMBER_ERROR)
        require(price > 0) { ErrorMessage.NON_POSITIVE_ERROR }
        require(price % 1000 == 0) { ErrorMessage.MODULO_ERROR }
        return price
    }
}

object WinningNumber {
    fun validate(inputWinningNumber: String): Set<Int> {
        val winningNumber = inputWinningNumber.split(",").mapNotNull { it.trim().toIntOrNull() }.toSet()
        require(winningNumber.size == 6) { ErrorMessage.LOTTO_COUNT_ERROR }
        require(Validation.isValidRange(*winningNumber.toIntArray())) { ErrorMessage.RANGE_ERROR }
        return winningNumber
    }
}

object BonusNumber {
    fun validate(inputBonusNumber: String, winningNumber: Set<Int>): Int {
        val bonusNumber =
            inputBonusNumber.toIntOrNull() ?: throw IllegalArgumentException(ErrorMessage.PARSE_NUMBER_ERROR)
        require(Validation.isValidRange(bonusNumber)) { ErrorMessage.RANGE_ERROR }
        require(Validation.isNotDuplicated(winningNumber, bonusNumber)) { ErrorMessage.DUPLICATED_NUMBER }
        return bonusNumber
    }
}