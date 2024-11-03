package lotto.adapter

import lotto.domain.model.BonusNumber

object BonusNumberAdapter {
    fun makeBonusNumberModel(input: String): BonusNumber {
        val bonusNumber: Int = input.toInt()
        return BonusNumber(bonusNumber)
    }
}