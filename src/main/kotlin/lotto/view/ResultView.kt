package lotto.view

import lotto.model.Lotto

class ResultView {

    fun displayPurchasedLotto(lottoCount: Int, lottos: List<Lotto>) {
        println("${lottoCount}개를 구매했습니다.")

        lottos.forEach { lotto ->
            println(lotto.getNumbers())
        }
        println()
    }

    private fun displayTitle() {
        println("당첨 통계")
        println("---")
    }
}