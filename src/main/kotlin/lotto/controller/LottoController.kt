package lotto.controller

import lotto.model.Lotto
import lotto.model.Rank
import lotto.utils.*
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val lottoGenerator = LottoGenerator()
    private val profitRateCalculator = ProfitRateCalculator()

    fun start() {
        val price = Price.validate(inputView.readPrice())
        val lottoCount = price / 1000
        val lotto = generateLotto(lottoCount)

        outputView.printLottoCount(lottoCount)
        outputView.printLotto(lotto)

        val winningNumber = WinningNumber.validate(inputView.readWinningNumber())
        val bonusNumber = BonusNumber.validate(inputView.readBonusNumber(), winningNumber)

        val rankCount = countRank(lotto, winningNumber, bonusNumber)

        outputView.printWinningStats(rankCount)
        outputView.printProfitRate(profitRateCalculator.calculate(rankCount, price))
    }

    private fun generateLotto(lottoCount: Int): List<Lotto> {
        val lotto = mutableListOf<Lotto>()
        repeat(lottoCount) {
            lotto.add(lottoGenerator.getLotto())
        }
        return lotto
    }

    private fun countRank(lotto: List<Lotto>, winningNumber: Set<Int>, bonusNumber: Int): Map<Rank, Int> {
        val rankCount = mutableMapOf<Rank, Int>()
        Rank.entries.forEach {
            rankCount[it] = 0
        }
        lotto.forEach {
            val rank = it.getRank(winningNumber, bonusNumber)
            rankCount[rank] = (rankCount[rank] ?: 0) + 1
        }
        rankCount.remove(Rank.NONE)
        return rankCount
    }
}