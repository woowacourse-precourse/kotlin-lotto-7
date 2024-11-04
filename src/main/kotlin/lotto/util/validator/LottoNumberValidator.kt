package lotto.util.validator

import lotto.util.constant.ErrorMessages
import lotto.util.constant.LottoRules

object LottoNumberValidator {

    fun validateLottoNumbers(numbers: List<Int>) {
        validateLottoNumberCount(numbers)
        validateLottoNumberRange(numbers)
        validateLottoNumberUniqueness(numbers)
    }

    private fun validateLottoNumberDelimiter(input: String) {
        require(input.contains(LottoRules.DELIMITER)) { ErrorMessages.LOTTO_NUMBER_DELIMITER }
    }

    private fun validateIsNumeric(input: List<String>) {
        require(input.all { it.toIntOrNull() != null }) { ErrorMessages.LOTTO_NUMBER_NUMERIC }
    }

    private fun validateLottoNumberCount(numbers: List<Int>) {
        require(numbers.size == LottoRules.LOTTO_NUMBER_COUNT) { ErrorMessages.LOTTO_NUMBER_COUNT }
    }

    private fun validateLottoNumberRange(numbers: List<Int>) {
        require(numbers.all { it in LottoRules.LOTTO_NUMBER_RANGE }) { ErrorMessages.LOTTO_NUMBER_RANGE }
    }

    private fun validateLottoNumberUniqueness(numbers: List<Int>) {
        require(numbers.distinct().size == numbers.size) { ErrorMessages.LOTTO_NUMBER_UNIQUE }
    }

    fun getValidatedWinningNumbers(winningNumbersInput: String): List<Int> {
        validateLottoNumberDelimiter(winningNumbersInput)

        val splittingNumbersInput = winningNumbersInput.split(LottoRules.DELIMITER)
        validateIsNumeric(splittingNumbersInput)

        val validatedNumbers = splittingNumbersInput.map { it.toInt() }
        validateLottoNumbers(validatedNumbers)

        return validatedNumbers
    }
}