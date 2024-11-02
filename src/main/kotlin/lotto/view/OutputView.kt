package lotto.view

import lotto.domain.entity.Lotto

class OutputView {
    fun showRandomLottos(lottos: List<Lotto>) {
        println("\n${lottos.size}$LOTTO_PURCHASE_MSG")
        lottos.forEach { println(it) }
        println()
    }

    companion object {
        const val LOTTO_PURCHASE_MSG = "개를 구매했습니다."
    }
}