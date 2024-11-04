package lotto.controller

import lotto.constants.Constants
import lotto.model.Lotto
import lotto.model.Rank
import lotto.model.Stat
import lotto.utils.LottoGenerator
import lotto.utils.StatCalculator
import lotto.utils.Validator
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val lottoGenerator = LottoGenerator()

    fun start() {
        val price = repeatLogic { Validator.getPrice(inputView.readPrice()) }
        val lottoCount = price / Constants.DIVISOR
        val lotto = generateLotto(lottoCount)

        outputView.printLottoCount(lottoCount)
        outputView.printLotto(lotto)

        val winningNumber = repeatLogic { Validator.getWinningNumber(inputView.readWinningNumber()) }
        val bonusNumber = repeatLogic { Validator.getBonusNumber(inputView.readBonusNumber(), winningNumber) }

        val stats = getStats(lotto, winningNumber, bonusNumber)
        outputView.printStats(stats)
        outputView.printProfitRate(StatCalculator.getProfitRate(stats, price))
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
        lotto.forEach { lottoItem ->
            val rank = StatCalculator.getRank(lottoItem.getNumbers(), winningNumber, bonusNumber)
            stats[rank.index].increaseCount()
        }
        stats.removeAt(Rank.NONE.index)
        return stats
    }

    private fun <T> repeatLogic(logic: () -> T): T {
        while (true) {
            val result = tryLogic(logic)
            if (result != null) return result
        }
    }

    private fun <T> tryLogic(logic: () -> T): T? {
        return try {
            logic()
        } catch (e: IllegalArgumentException) {
            outputView.printErrorMessage(e.message)
            null
        }
    }
}