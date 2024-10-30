package lotto.domain

import lotto.constants.Constants.COMMA

class InputNumbers(rawWinningNumbers: String, rawBonusNumber: String) {

    val winningNumbers = rawWinningNumbers.split(COMMA).map { it.toInt() }
    val bonusNumber = rawBonusNumber.toInt()
}