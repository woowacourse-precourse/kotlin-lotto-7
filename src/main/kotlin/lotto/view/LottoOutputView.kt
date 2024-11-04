package lotto.view

import lotto.model.LottoRank
import lotto.model.LottoResultDetail
import lotto.util.LottoOutputText

class LottoOutputView {
    fun outputPurchasePrice() {
        println(LottoOutputText.INPUT_PURCHASE_PRICE_TEXT)
    }

    fun outputLottoList(lottoList: List<List<Int>>) {
        println("${lottoList.size}${LottoOutputText.LOTTO_GENERATE_FINISH_TEXT}")
        lottoList.forEach { lotto ->
            println(lotto)
        }
    }

    fun outputWinningNumber() {
        println()
        println(LottoOutputText.INPUT_WINNING_NUMBERS)
    }

    fun outputBonusNumber() {
        println()
        println(LottoOutputText.INPUT_BONUS_NUMBER)
    }

    fun outputLottoResult(lottoResultDetail: LottoResultDetail)  {
        println()
        println("당첨 통계")
        println("---")
        LottoRank.entries.forEach { rank->
            if (rank != LottoRank.NOTHING) {
                val rankCount = lottoResultDetail.lottoRankList.count { it == rank }
                println("${rank.print()} - ${rankCount}개")
            }
        }
        println("총 수익률은 ${lottoResultDetail.roundedRateOfReturn}%입니다.")
    }
}