package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.Lotto

class LottoView {
    fun printError(message: String?) = println(message)

    fun printLottoPurchaseRequest() = println("구입금액을 입력해 주세요.")

    fun inputLottoPurchaseAmount(): String = Console.readLine()

    fun printLottoCount(count: Int) = println("\n${count}개를 구매했습니다.")

    fun printLottos(lottos: List<Lotto>) {
        lottos.forEach {
            println(it.toString())
        }
    }

    fun printWinningNumberRequest() = println("\n당첨 번호를 입력해 주세요.")

    fun inputWinningNumber(): String = Console.readLine()

    fun printBonusNumberRequest() = println("\n보너스 번호를 입력해 주세요.")

    fun inputBonusNumber(): String = Console.readLine()

    fun printLottoRankHeader() = println("\n당첨 통계\n---")

}
