package lotto.domain.usecase

import java.math.BigDecimal
import java.math.RoundingMode

class CalculateLottoReturnUseCase {
    fun execute(winningPrizes: List<Int>, totalLottoCost: Int): String {
        val totalWinningPrizes = winningPrizes.sumOf { it.toBigDecimal() }
        val lottoProfitRate = calculateProfitRate(totalWinningPrizes, totalLottoCost.toBigDecimal())
        return lottoProfitRate.toString() + PERCENT
    }

    private fun calculateProfitRate(profit: BigDecimal, expenditure: BigDecimal) =
        profit.multiply(BigDecimal(PERCENTAGE_MULTIPLIER)).divide(expenditure, ROUNDING_SCALE, RoundingMode.HALF_UP)

    companion object {
        private const val PERCENT = "%"
        private const val ROUNDING_SCALE = 1
        private const val PERCENTAGE_MULTIPLIER = 100
    }
}