package lotto.View

import lotto.Model.Lotto

fun printLottoInfo(count: Int, lottos: List<Lotto>) {
    println("${count}개를 구매했습니다.")
    lottos.forEach { lotto ->
        println(lotto.getNumbers())
    }
}