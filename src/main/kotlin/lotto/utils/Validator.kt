package lotto.utils

import lotto.constants.Constants
import lotto.constants.ErrorMessage

object Validator {
    fun getPrice(inputPrice: String): Int {
        val price = inputPrice.toIntOrNull() ?: throw IllegalArgumentException(ErrorMessage.PARSE_NUMBER_ERROR)
        require(isPositive(price)) { ErrorMessage.NON_POSITIVE_ERROR }
        require(isDivisible(price)) { ErrorMessage.MODULO_ERROR }
        return price
    }

    fun getWinningNumber(inputWinningNumber: String): Set<Int> {
        val winningNumber = inputWinningNumber.split(Constants.DELIMITER).mapNotNull { it.trim().toIntOrNull() }
        require(checkSize(winningNumber)) { ErrorMessage.LOTTO_COUNT_ERROR }
        require(isUniqueNumbers(winningNumber)) { ErrorMessage.DUPLICATED_NUMBER }
        require(isValidRange(*winningNumber.toIntArray())) { ErrorMessage.RANGE_ERROR }
        return winningNumber.toSet()
    }

    fun getBonusNumber(inputBonusNumber: String, winningNumber: Set<Int>): Int {
        val bonusNumber =
            inputBonusNumber.toIntOrNull() ?: throw IllegalArgumentException(ErrorMessage.PARSE_NUMBER_ERROR)
        require(isValidRange(bonusNumber)) { ErrorMessage.RANGE_ERROR }
        require(isDuplicatedBonusNumber(winningNumber, bonusNumber)) { ErrorMessage.DUPLICATED_NUMBER }
        return bonusNumber
    }

    fun isUniqueNumbers(winningNumber: List<Int>) = winningNumber.size == winningNumber.distinct().size

    private fun isValidRange(vararg numbers: Int): Boolean =
        numbers.map { it in Constants.LOTTO_RANGE_START..Constants.LOTTO_RANGE_END }.all { it }

    private fun isDuplicatedBonusNumber(winningNumber: Set<Int>, bonusNumber: Int): Boolean =
        !winningNumber.contains(bonusNumber)

    private fun isPositive(price: Int) = price > 0

    private fun isDivisible(price: Int) = price % Constants.DIVISOR == 0

    private fun checkSize(winningNumber: List<Int>) = winningNumber.size == Constants.LOTTO_SIZE
}