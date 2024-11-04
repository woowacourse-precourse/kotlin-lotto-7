package lotto.View

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto
import lotto.LottoResult

class OutputView {

    fun outputLottoNum(amount: Int): MutableList<List<Int>> {

        println("${amount}개를 구매했습니다.")

        var outputLotto = mutableListOf<List<Int>>()

        for (num in 0 until amount) {
            outputLotto.add(Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted())
        }

        outputLotto.forEach { lottoNumbers ->
            println(lottoNumbers)
        }

        return outputLotto
    }

    fun outputResult(
        payment: Int,
        outputLottoNum: MutableList<List<Int>>,
        lottoNum: List<Int>,
        bonusLottoNum: Int
    ) {
        println("당첨 통계\n---")

        val matchResult = Lotto(lottoNum).checkMatch(outputLottoNum, bonusLottoNum)

        val matchCountLabels = listOf(
            "3개 일치 (5,000원) -",
            "4개 일치 (50,000원) -",
            "5개 일치 (1,500,000원) -",
            "5개 일치, 보너스 볼 일치 (30,000,000원) -",
            "6개 일치 (2,000,000,000원) -"
        )

        matchResult.forEachIndexed { index, count ->
            println("${matchCountLabels[index]} ${count}개")
        }

        val revenue = LottoResult().calculateRevenueRate(payment, matchResult)

        println("총 수익률은 ${revenue}%입니다.")
    }
}