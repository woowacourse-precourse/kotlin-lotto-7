package lotto.controller

import lotto.model.Lotto
import lotto.model.LottoHandler
import lotto.model.LottoRank
import lotto.util.Constant
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val lottoHandler = LottoHandler()

    fun run() {
        val lottoMoney = inputView.readLottoMoney()
        val lottoCount = lottoMoney / Constant.LOTTO_PRICE
        outputView.printLottoCount(lottoCount)

        val lottos = lottoHandler.generateLottos(lottoCount)
        outputView.printLottos(lottos)

        val winningNumbers = inputView.readWinningNumbers()
        val bonusNumber = inputView.readBonusNumber()

        val winCounts = getWinCounts(lottos, winningNumbers, bonusNumber)
        outputView.printWinCounts(winCounts)

        val revenue = getRevenue(winCounts)
        outputView.printRevenueToCostRatio(revenue, lottoMoney)
    }

    private fun getWinCounts(lottos: Set<Lotto>, winningNumbers: List<Int>, bonusNumber: Int): Map<LottoRank, Int> {
        val winCounts = mutableMapOf<LottoRank, Int>().withDefault { 0 }
        lottos.forEach {
            val matchCount = it.countMatches(winningNumbers)
            val hasBonus = it.hasBonus(bonusNumber)
            val rank = LottoRank.getRank(matchCount, hasBonus)
            winCounts[rank] = winCounts.getValue(rank) + 1
        }
        return winCounts
    }

    private fun getRevenue(winCounts: Map<LottoRank, Int>): Int {
        var revenue = 0
        winCounts.forEach { revenue += it.value * it.key.prize }
        return revenue
    }
}
