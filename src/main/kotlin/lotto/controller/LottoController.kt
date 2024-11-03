package lotto.controller

import lotto.model.LottoHandler
import lotto.model.LottoRank
import lotto.util.Constant
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    fun run() {
        val inputView = InputView()
        val outputView = OutputView()
        val lottoHandler = LottoHandler()

        val lottoMoney = inputView.readLottoMoney()
        val lottoCount = lottoMoney / Constant.LOTTO_PRICE
        outputView.printLottoCount(lottoCount)

        val lottos = lottoHandler.generateLottos(lottoCount)
        outputView.printLottos(lottos)

        val winningNumbers = inputView.readWinningNumbers()
        val bonusNumber = inputView.readBonusNumber()

        val winCounts = mutableMapOf<LottoRank, Int>().withDefault { 0 }
        lottos.forEach {
            val matchCount = it.countMatches(winningNumbers)
            val hasBonus = it.hasBonus(bonusNumber)
            val rank = LottoRank.getRank(matchCount, hasBonus)
            winCounts[rank] = winCounts.getValue(rank) + 1
        }

        outputView.printWinCounts(winCounts)
    }
}
