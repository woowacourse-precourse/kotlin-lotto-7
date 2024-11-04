package lotto.domain

import lotto.constants.ErrorConstants.ERROR_INPUTNUMBER_BONUSNUMBER_DUPLICATE
import lotto.constants.ErrorConstants.ERROR_NUMBERS_COUNT
import lotto.constants.ErrorConstants.ERROR_NUMBERS_DUPLICATE
import lotto.constants.ErrorConstants.ERROR_NUMBER_ONLY_NUMERIC
import lotto.constants.ErrorConstants.ERROR_NUMBER_RANGE
import lotto.constants.LottoConstants.COMMA
import lotto.constants.LottoConstants.LOTTO_NUMBER_RANGE
import lotto.constants.LottoConstants.MAX_LOTTO_NUMBER
import lotto.constants.LottoConstants.MIN_LOTTO_NUMBER

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

        require(numbers.size == LOTTO_NUMBER_RANGE) { ERROR_NUMBERS_COUNT }
        require(numbers.toSet().size == numbers.size) { ERROR_NUMBERS_DUPLICATE }
        require(bonusNumber in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER
                && numbers.all { it in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER }) {
            ERROR_NUMBER_RANGE
        }
        require(!numbers.contains(bonusNumber)) { ERROR_INPUTNUMBER_BONUSNUMBER_DUPLICATE }
    }
}
