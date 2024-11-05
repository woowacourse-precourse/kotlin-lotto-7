package lotto.utils

object CalculateUtils {

    fun getEarningsRate(earningMoney: Long, investMoney: Int): String {
        val earningsRate = calculateEarningsRate(earningMoney, investMoney)
        return String.format("%.1f", earningsRate)
    }

    private const val RATE_PERCENT = 100
    private const val EMPTY_INVEST_MONEY = 0
    private const val ZERO_EARNINGS = 0
    fun calculateEarningsRate(earningMoney: Long, investMoney: Int): Number {
        val earningsRate = if (investMoney == EMPTY_INVEST_MONEY) {
            ZERO_EARNINGS
        } else {
            (earningMoney.toDouble() / investMoney) * RATE_PERCENT
        }
        return earningsRate
    }

}