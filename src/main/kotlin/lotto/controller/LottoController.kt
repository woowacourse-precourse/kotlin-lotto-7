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
    private var purchasedLottos = emptyList<Lotto>()
    private lateinit var amount: LottoAmount

    fun start() {
        while (true) {
            try {
                amount = LottoAmount(inputView.inputAmount())
                break
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }

        printLottos()
    }

    private fun printLottos() {
        val lottosCount = cashier.calculateLottoCount(amount)
        outputView.printLottosCount(lottosCount)

        val lottos = lottoMachine.createLottos(lottosCount)
        lottos.forEach { lotto ->
            println(lotto.lottoNumbers.sorted())
        }

        purchasedLottos = lottos

        inputWinningLottery()
    }

    private fun inputWinningLottery() {
        lateinit var winningLottoNumber: Lotto
        var winningBonusNumber: Int
        var winningLotto: WinningLotto

        println()
        while (true) {
            try {
                winningLottoNumber = Lotto(inputView.inputWinningLottoNumber())
                break
            } catch (e: Exception) {
                println(e.message)
            }
        }

        println()
        while (true) {
            try {
                winningBonusNumber = inputView.inputBonusNumber()
                winningLotto = WinningLotto(winningLottoNumber, winningBonusNumber)
                break
            } catch (e: Exception) {
                println(e.message)
            }
        }

        printWinningStatistics(winningLotto)
    }

    private fun printWinningStatistics(winningLotto: WinningLotto) {
        val prizes = mutableListOf<LottoPrize>()

        purchasedLottos.forEach { prizes.add(it.compareWinningLotto(winningLotto)) }

        val prizeCounts = prizes.groupingBy { it }.eachCount()
        outputView.printWinningStatisticsTitle()

        LottoPrize.entries
            .reversed()
            .filter { it != NONE_PRIZE }
            .forEach { prize ->
                val count = prizeCounts[prize] ?: 0
                outputView.printWinningStatistics(prize, count)
            }

        printLottoYield(prizes)
    }

    private fun printLottoYield(prizes: List<LottoPrize>) {
        val totalPrizeMoney = prizes.sumOf { it.price }
        val yield = (totalPrizeMoney.toDouble() / amount.lottoAmount) * 100
        outputView.printLottoYield(yield)
    }
}