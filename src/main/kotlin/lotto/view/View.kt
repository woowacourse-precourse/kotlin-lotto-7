package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.domain.lotto.LottoTicket


fun purchaseAmountView(): String {
    println("구입금액을 입력해 주세요.")
    return Console.readLine()
}

fun purchaseLottoView(count: Int, lottoTicket: LottoTicket) {
    println()
    println("${count}개를 구매했습니다.")
    println(lottoTicket.toString())
}

fun winningNumberView(): String {
    println()
    println("당첨 번호를 입력해 주세요.")
    return Console.readLine()
}