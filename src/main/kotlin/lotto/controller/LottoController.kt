package lotto.controller

import lotto.model.Lotto
import lotto.model.Rank
import lotto.model.Stat
import lotto.utils.*
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val lottoGenerator = LottoGenerator()
    private val profitRateCalculator = ProfitRateCalculator()

    fun start() {
        val price = repeatLogic { Price.validate(inputView.readPrice()) }
        val lottoCount = price / 1000
        val lotto = generateLotto(lottoCount)

        outputView.printLottoCount(lottoCount)
        outputView.printLotto(lotto)

        val winningNumber = repeatLogic { WinningNumber.validate(inputView.readWinningNumber()) }
        val bonusNumber = repeatLogic { BonusNumber.validate(inputView.readBonusNumber(), winningNumber) }

        val stats = getStats(lotto, winningNumber, bonusNumber)

        outputView.printStats(stats)
        outputView.printProfitRate(profitRateCalculator.calculate(stats, price))
    }

    private fun generateLotto(lottoCount: Int): List<Lotto> {
        val lotto = mutableListOf<Lotto>()
        repeat(lottoCount) {
            lotto.add(lottoGenerator.getLotto())
        }
        return lotto
    }

    private fun getStats(lotto: List<Lotto>, winningNumber: Set<Int>, bonusNumber: Int): List<Stat> {
        val stats = mutableListOf<Stat>()
        Rank.entries.forEach { rank ->
            stats.add(Stat(rank))
        }
        lotto.forEach {
            val rank = it.getRank(winningNumber, bonusNumber)
            stats[rank.index].increaseCount()
        }
        stats.removeAt(Rank.NONE.index)
        return stats
    }

    private fun <T> repeatLogic(logic: () -> T): T {
        do {
            try {
                return logic()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        } while (true)
    }
}