package lotto.model

import lotto.utils.Constants

class LottoCalculator {
    companion object {
        fun calculate(lottos: Lottos, winningNumbers: List<Int>, bonusNumber: Int): MutableMap<LottoRank, Int> {
            // LottoRank의 모든 인자 key to 0으로 초기화
            val result = mutableMapOf<LottoRank, Int>()
            LottoRank.entries.forEach {
                result[it] = 0
            }
            lottos.getLottos().forEach { lotto ->
                val matchCount = lotto.match(winningNumbers)
                val bonusMatch = lotto.matchBonus(bonusNumber)
                val rank = LottoRank.getRank(matchCount, bonusMatch)
                result[rank] = result.getOrDefault(rank, 0) + 1

            }
            return result
        }

        fun calculateProfitRate(result: MutableMap<LottoRank, Int>): Double {
            // 전체 수익 / 구매 금액
            // total lotto 구매 가격
            val totalLotto = result.values.sum() * Constants.LOTTO_PRICE
            // total lotto 당첨 금액
            val totalLottoPrize = result.map { it.key.prize * it.value }.sum()
            return totalLottoPrize.toDouble() / totalLotto * 100
        }
    }

}