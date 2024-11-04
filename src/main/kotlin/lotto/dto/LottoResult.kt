package lotto.dto

import lotto.model.LottoWinning

data class LottoResult(
    val result: Map<LottoWinning, Int>,
    val profitRate: Double
)