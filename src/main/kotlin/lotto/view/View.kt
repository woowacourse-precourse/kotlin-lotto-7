package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.domain.lotto.LottoTicket
import lotto.domain.winning.WinningStatistics

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

fun bonusNumberView(): String {
    println()
    println("보너스 번호를 입력해 주세요.")
    return Console.readLine()
}

fun printWinningStatistics(winningStatistics: WinningStatistics) {
    println()
    println("당첨 통계")
    println("---")
    println(winningStatistics.showStatus())
}

fun printProfitRate(rate: Double) {
    println("총 수익률은 ${String.format("%.1f", rate)}%입니다.")
}