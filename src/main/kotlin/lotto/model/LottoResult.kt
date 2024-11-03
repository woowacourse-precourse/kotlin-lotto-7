package lotto.model

data class LottoResult(
    val result: Map<LottoWinning, Int>,
    val profitRate: Double
)