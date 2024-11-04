package lotto.view

import lotto.constant.Message.LOTTO_RATE_OF_RETURN
import lotto.constant.Message.LOTTO_RESULT_MESSAGE
import lotto.model.Lotto
import lotto.model.LottoTotalMatchResult

class Output {
    fun printLottoNumbers(lottos: List<Lotto>) {
        println("${lottos.size}개를 구매했습니다.")
        repeat(lottos.size) { idx ->
            println(lottos[idx].getLottoNumbers())
        }
        println()
    }

    fun printTotalLottoPrize(totalMatchResult: LottoTotalMatchResult, rateOfReturn: Float) {
        println(LOTTO_RESULT_MESSAGE)
        println("3개 일치 (5,000원) - ${totalMatchResult.prizeCount5}개")
        println("4개 일치 (50,000원) - ${totalMatchResult.prizeCount4}개")
        println("5개 일치 (1,500,000원) - ${totalMatchResult.prizeCount3}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${totalMatchResult.prizeCount2}개")
        println("6개 일치 (2,000,000,000원) - ${totalMatchResult.prizeCount1}개")
        println(LOTTO_RATE_OF_RETURN.format(rateOfReturn))
    }
}