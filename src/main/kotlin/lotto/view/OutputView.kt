package lotto.view

import lotto.Constants
import lotto.model.Lotto

class OutputView {
    fun printLottoAmountMessage(amount: Int) = println("${amount}개를 구매했습니다.")

    fun printLottoNumber(lottoTickets: List<Lotto>) {
        lottoTickets.forEach { lotto -> println(lotto.getNumbers()) }
    }

    fun printResult() {
        println(Constants.OUTPUT_RESULT_MESSAGE)
        println(Constants.LINE_SEPARATOR)
    }
}