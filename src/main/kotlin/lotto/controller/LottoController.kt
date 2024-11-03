package lotto.controller

import lotto.*
import lotto.LottoPrize.NONE_PRIZE
import lotto.LottoPrize.SECOND_PRIZE
import java.text.DecimalFormat

class LottoController(
    private val cashier: Cashier,
    private val lottoMachine: LottoMachine,
    private val inputView: InputView,
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

        println()
        println("${lottosCount}개를 구매했습니다.")
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

        println()
        println("당첨 통계\n---")

        LottoPrize.entries
            .reversed()
            .filter { it != NONE_PRIZE }
            .forEach { prize ->
                val count = prizeCounts[prize] ?: 0

                if (prize == SECOND_PRIZE) {
                    println("${prize.matchingCount}개 일치, 보너스 볼 일치 (${THOUSAND_COMMA.format(prize.price)}원) - ${count}개")
                    return@forEach
                }
                println("${prize.matchingCount}개 일치 (${THOUSAND_COMMA.format(prize.price)}원) - ${count}개")
            }

        printLottoYield(prizes)
    }

    private fun printLottoYield(prizes: List<LottoPrize>) {
        val totalPrizeMoney = prizes.sumOf { it.price }
        val yield = (totalPrizeMoney.toDouble() / amount.lottoAmount) * 100
        val formattedYield = String.format("%.1f", yield)
        println("총 수익률은 ${formattedYield}%입니다.")
    }

    companion object {
        private val THOUSAND_COMMA = DecimalFormat("#,###")
    }
}