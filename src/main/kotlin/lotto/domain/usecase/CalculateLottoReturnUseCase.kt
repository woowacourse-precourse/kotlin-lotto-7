package lotto.domain.usecase

import java.math.BigDecimal
import java.math.RoundingMode

class CalculateLottoReturnUseCase {
    fun execute(winningPrizes: List<Int>, totalLottoCost: Int): String {
        val totalWinningPrizes = winningPrizes.sumOf { it.toBigDecimal() }
        val lottoProfitRate = calculateProfitRate(totalWinningPrizes, totalLottoCost.toBigDecimal())
        return "${lottoProfitRate.stripTrailingZeros()}%"
    }

    private fun calculateProfitRate(profit: BigDecimal, expenditure: BigDecimal) =
        profit.divide(expenditure, 3, RoundingMode.HALF_UP).multiply(
            BigDecimal(100)
        )
}