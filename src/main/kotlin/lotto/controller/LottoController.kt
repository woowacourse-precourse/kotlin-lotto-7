package lotto.controller

import lotto.model.*
import lotto.model.LottoPrize.NONE_PRIZE
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(
    private val lottoCalculator: LottoCalculator,
    private val lottoMachine: LottoMachine,
    private val inputView: InputView,
    private val outputView: OutputView,
) {
    fun runLottoGame() {
        val lottoAmount: Int = getLottoAmount()
        val purchasedLottos: List<Lotto> = generateLottos(lottoAmount)

        val winningLottoNumber: List<Int> = getWinningLottoNumber()
        val winningBonusNumber: Int = getBonusNumber()
        val winningLotto: WinningLotto = createWinningLotto(winningLottoNumber, winningBonusNumber)

        val lottoPrizes: List<LottoPrize> = lottoCalculator.calculateStatistics(purchasedLottos, winningLotto)
        showLottoStatistics(lottoPrizes)
        showLottoYield(lottoPrizes, lottoAmount)
    }

    private fun getLottoAmount(): Int {
        while (true) {
            try {
                return LottoAmount(inputView.inputAmount()).money
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun generateLottos(lottoAmount: Int): List<Lotto> {
        val lottosCount = lottoCalculator.calculateLottoCount(lottoAmount)
        val lottos = lottoMachine.createLottos(lottosCount)

        outputView.printLottosCount(lottosCount)
        lottos.forEach { lotto ->
            println(lotto.getSortedNumbers())
        }

        return lottos
    }

    private fun getWinningLottoNumber(): List<Int> {
        while (true) {
            try {
                return Lotto(inputView.inputWinningLottoNumber()).getNumbers()
            } catch (e: Exception) {
                println(e.message)
            }
        }
    }

    private fun getBonusNumber(): Int {
        while (true) {
            try {
                return inputView.inputBonusNumber()
            } catch (e: Exception) {
                println(e.message)
            }
        }
    }

    private fun createWinningLotto(lottoNumber: List<Int>, bonusNumber: Int): WinningLotto {
        while (true) {
            try {
                return WinningLotto(lottoNumber, bonusNumber)
            } catch (e: Exception) {
                println(e.message)
            }
        }
    }

    private fun showLottoStatistics(prizes: List<LottoPrize>) {
        outputView.printWinningStatisticsTitle()

        val prizeCounts = prizes.groupingBy { it }.eachCount()

        LottoPrize.entries
            .reversed()
            .filter { it != NONE_PRIZE }
            .forEach { prize ->
                val count = prizeCounts[prize] ?: 0
                outputView.printWinningStatistics(prize, count)
            }
    }

    private fun showLottoYield(prizes: List<LottoPrize>, amount: Int) {
        val yield = lottoCalculator.calculateYield(prizes, amount)
        outputView.printLottoYield(yield)
    }
}