package lotto.view

import lotto.model.Lotto

class OutputViewImpl : OutputView {

    override fun printNewLine() = println()

    override fun printPurchaseSummary(lottoBundle: List<Lotto>) {
        println("${lottoBundle.size}개를 구매했습니다.")
        for (lotto in lottoBundle) {
            println(lotto.getNumbers().joinToString(", ", "[", "]"))
        }
        printNewLine()
    }
}