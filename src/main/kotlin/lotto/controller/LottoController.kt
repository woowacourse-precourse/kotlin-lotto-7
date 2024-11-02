package lotto.controller

import camp.nextstep.edu.missionutils.Console.readLine
import lotto.*
import lotto.LottoPrize.NONE_PRIZE
import java.text.DecimalFormat

class LottoController(
    private val cashier: Cashier,
    private val lottoMachine: LottoMachine,
) {
    private var purchasedLottos = emptyList<Lotto>()

    fun start() {
        println("구입금액을 입력해 주세요.")
        val inputAmount = readLine()
        require(inputAmount.isNotBlank()) { "[ERROR] 공백은 입력할 수 없습니다." }
        val amount =
            LottoAmount(
                inputAmount.toIntOrNull()
                    ?: throw IllegalArgumentException("[ERROR] 정수만 입력할 수 있습니다.")
            )

        printLottos(amount)
    }

    private fun printLottos(amount: LottoAmount) {
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
        println("당첨 번호를 입력해 주세요.")
        val winningLottoNumber = Lotto(readLine().split(",").map { it.toInt() })
        println("보너스 번호를 입력해 주세요.")
        val winningBonusNumber = readLine().toInt()

        val winningLotto = WinningLotto(winningLottoNumber, winningBonusNumber)

        printWinningStatistics(winningLotto)
    }

    private fun printWinningStatistics(winningLotto: WinningLotto) {
        val prizes = mutableListOf<LottoPrize>()

        purchasedLottos.forEach { prizes.add(it.compareWinningLotto(winningLotto)) }

        val prizeCounts = prizes.groupingBy { it }.eachCount()

        LottoPrize.entries
            .reversed()
            .filter { it != NONE_PRIZE }
            .forEach { prize ->
                val count = prizeCounts[prize] ?: 0
                println("${prize.matchingCount}개 일치 (${THOUSAND_COMMA.format(prize.price)}원) - ${count}개")
            }
    }

    companion object {
        private val THOUSAND_COMMA = DecimalFormat("#,###")
    }
}