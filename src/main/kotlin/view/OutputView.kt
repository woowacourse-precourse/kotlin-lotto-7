package view

import lotto.Lotto

object OutputView {
    fun printLotto(count: Int, lottoes: List<Lotto>) {
        println("${count}개를 구매했습니다.")
        lottoes.forEach { println(it) }
    }

}