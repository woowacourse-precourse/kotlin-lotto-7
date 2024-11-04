package lotto.view

import lotto.model.Lotto

class OutputView {
    fun purchasedMessage(num: Int) {
        println("${num}개를 구매했습니다.")
    }

    fun purchasedLotto(lottos: List<Lotto>) {
        for (lotto in lottos) {
            println(lotto)
        }
    }

    fun resultStatistics(ranking: List<Int>, profitRatio: Double) {
        println(
            "당첨 통계\n" +
                    "---"
        )
        println("${3}개 일치 (5,000원) - ${ranking[5]}개\n" +
                "${4}개 일치 (50,000원) - ${ranking[4]}개\n" +
                "${5}개 일치 (1,500,000원) - ${ranking[3]}개\n" +
                "${5}개 일치, 보너스 볼 일치 (30,000,000원) - ${ranking[2]}개\n" +
                "${6}개 일치 (2,000,000,000원) - ${ranking[1]}개\n")
        println("총 수익률은 ${profitRatio}%입니다.")
    }
}