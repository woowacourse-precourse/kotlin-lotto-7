package lotto.view

import lotto.model.Lotto

object OutputView {
    fun printExceptionMessage(message: String?) {
        println(message)
    }

    fun printPurchaseLotto(lottos: List<Lotto>) {
        println("${lottos.size}개를 구매했습니다.")
        lottos.forEach { println(it) }
    }
}
