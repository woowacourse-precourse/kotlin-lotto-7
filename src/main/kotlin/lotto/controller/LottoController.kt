package lotto.controller

import lotto.model.*
import lotto.model.LottoPrize.NONE_PRIZE
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(
    private val cashier: Cashier,
    private val lottoMachine: LottoMachine,
    private val inputView: InputView,
    private val outputView: OutputView,
) {
    fun runLottoGame() {
        val lottoAmount = getLottoAmount()
        val purchasedLottos = issueLottos(lottoAmount.lottoAmount)

        val winningLottoNumber = getWinningLottoNumber()
        val winningBonusNumber = getBonusNumber()
        val winningLotto = createWinningLotto(winningLottoNumber, winningBonusNumber)

        val lottoPrizes = calculateLottoStatistics(purchasedLottos, winningLotto)
        showLottoStatistics(lottoPrizes)
        showLottoYield(lottoPrizes, lottoAmount.lottoAmount)
    }

    private fun getLottoAmount(): LottoAmount {
        while (true) {
            try {
                return LottoAmount(inputView.inputAmount())
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun issueLottos(lottoAmount: Int): List<Lotto> {
        val lottosCount = cashier.calculateLottoCount(lottoAmount)
        outputView.printLottosCount(lottosCount)

        val lottos = lottoMachine.createLottos(lottosCount)
        lottos.forEach { lotto ->
            println(lotto.lottoNumbers.sorted())
        }

        return lottos
    }

    private fun getWinningLottoNumber(): Lotto {
        while (true) {
            try {
                return Lotto(inputView.inputWinningLottoNumber())
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

    private fun createWinningLotto(lottoNumber: Lotto, bonusNumber: Int): WinningLotto {
        while (true) {
            try {
                return WinningLotto(lottoNumber, bonusNumber)
            } catch (e: Exception) {
                println(e.message)
            }
        }
    }

    private fun calculateLottoStatistics(purchasedLottos: List<Lotto>, winningLotto: WinningLotto): List<LottoPrize> {
        return purchasedLottos.map { it.compareWinningLotto(winningLotto) }
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
        val totalPrizeMoney = prizes.sumOf { it.price }
        val yield = (totalPrizeMoney.toDouble() / amount) * 100
        outputView.printLottoYield(yield)
    }
}