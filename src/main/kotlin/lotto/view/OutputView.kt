package lotto.view

import lotto.model.Lotto

class OutputView {
    fun printLottoCount(count: Int) {
        println("$count$MESSAGE_LOTTO_COUNT")
    }

    fun printLottos(lottos: Set<Lotto>) {
        lottos.forEach { println(it.toString()) }
    }

    companion object {
        const val MESSAGE_LOTTO_COUNT = "개를 구매했습니다."
    }
}
