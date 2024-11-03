package lotto.view

import lotto.model.Lotto
import lotto.model.LottoWinning

interface OutputView {
    fun printNewLine()
    fun printPurchaseSummary(lottoBundle: List<Lotto>)
    fun printWinningStatistics(winningStatistics: Map<LottoWinning, Int>)
    fun printProfitRate(profitRate: Double)
}