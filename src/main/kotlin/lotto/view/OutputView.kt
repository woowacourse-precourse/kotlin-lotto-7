package lotto.view

import lotto.Constants

class OutputView {
    fun printLottoAmountMessage(amount: Int) = println("${amount}개를 구매했습니다.")

    fun printResult() {
        println(Constants.OUTPUT_RESULT_MESSAGE)
        println(Constants.LINE_SEPARATOR)
    }
}