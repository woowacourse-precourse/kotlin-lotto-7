package lotto.model

import lotto.Validator

class BonusNumber(private val bonusNumber: String, private val winningNumbers: List<Int>) {
    init {
        Validator().checkBonusNumber(bonusNumber, winningNumbers)
    }
}