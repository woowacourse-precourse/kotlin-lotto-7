package lotto.controller

import camp.nextstep.edu.missionutils.Console.readLine
import lotto.Cashier
import lotto.LottoAmount
import lotto.LottoMachine

class LottoController(
    private val cashier: Cashier,
    private val lottoMachine: LottoMachine,
) {

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
            println(lotto.lottoNumber)
        }
    }
}