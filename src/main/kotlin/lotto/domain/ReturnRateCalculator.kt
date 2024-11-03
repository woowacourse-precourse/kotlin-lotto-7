package lotto.domain

import kotlin.math.round

class ReturnRateCalculator {
    fun calculate(cost: Long, profit: Long): Double {
        val profitRate = (profit.toDouble() / cost) * 100
        return round(profitRate * 10) / 10
    }
}