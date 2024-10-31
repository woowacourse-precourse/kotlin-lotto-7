package lotto.domain

import lotto.constants.ErrorConstants.ERROR_NUMBERS_COUNT
import lotto.constants.ErrorConstants.ERROR_NUMBERS_DUPLICATE
import lotto.constants.ErrorConstants.ERROR_NUMBER_ONLY_NUMERIC
import lotto.constants.ErrorConstants.ERROR_NUMBER_RANGE
import lotto.constants.LottoConstants.COMMA

class InputNumbers(rawWinningNumbers: String, rawBonusNumber: String) {

    val winningNumbers: List<Int>
    val bonusNumber: Int

    init {
        val numbers = rawWinningNumbers
            .split(COMMA)
            .map { it.toIntOrNull() ?: throw IllegalArgumentException(ERROR_NUMBER_ONLY_NUMERIC) }
        winningNumbers = numbers
        bonusNumber = rawBonusNumber.toIntOrNull()
            ?: throw IllegalArgumentException(ERROR_NUMBER_ONLY_NUMERIC)

        require(numbers.size == 6) { ERROR_NUMBERS_COUNT }
        require(numbers.toSet().size == 6) { ERROR_NUMBERS_DUPLICATE }
        require(bonusNumber in 1..45 && numbers.all { it in 1..45 }) {
            ERROR_NUMBER_RANGE
        }
    }
}
