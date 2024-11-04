package lotto.model

import lotto.utils.LottoException

class Bonus(private val bonus: Int) {
    init {
        require(bonus > 0 && bonus < 46) { LottoException.NOT_LOTTO }
        require(bonus.toInt() != null) { LottoException.NOT_LOTTO }
    }

    fun returnBonus(): Int {
        return bonus
    }
}