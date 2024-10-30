package lotto.view

import lotto.Lotto

object OutputView {
    fun printPurchasedLottos(lottos: List<Lotto>) {
        println("${lottos.size}개를 구매했습니다.")
        lottos.forEach { lotto ->
            println(lotto.getNumbers())
        }
    }
}