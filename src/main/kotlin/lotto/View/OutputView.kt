package lotto.View

import lotto.Lotto

class OutputView {
    fun printLottos(lottos: List<Lotto>) {
        println("${lottos.size}개를 구매했습니다.")
        lottos.forEach { lotto ->
            println(lotto.getNumbers())
        }
        println()
    }
}