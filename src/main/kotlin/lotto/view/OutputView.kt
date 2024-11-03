package lotto.view

import lotto.domain.Lotto

class OutputView {
    fun printPurchaseAmount(amount: Int) {
        println("${amount}개를 구매했습니다.")
    }

    fun printLottoStatus(lottos: List<Lotto>) {
        lottos.forEach {lotto ->
            println(lotto.getNumbers().joinToString(", ", "[", "]"))
        }
    }
}