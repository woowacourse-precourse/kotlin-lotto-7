package lotto.calculator

import lotto.constants.Format.DELIMITER_COMMA
import lotto.constants.Format.DELIMITER_EMPTY
import lotto.enums.Rank

class LottoProfitCalculator(private val lottoStats: List<Rank>, private val amount: Int) {

    private var profitRate = 0.0

    init {
        calculateProfit()
    }

    private fun calculateProfit() {
        val winningMoney = lottoStats.sumOf { it.prize.replace(DELIMITER_COMMA, DELIMITER_EMPTY).toInt() }

        if (winningMoney != 0) profitRate = winningMoney.toDouble() / amount * 100
    }

    fun getLottoProfit() = profitRate
}