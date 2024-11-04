package lotto.constant


import lotto.constant.BonusResult.BONUS_MATCH
import lotto.constant.BonusResult.BONUS_MISMATCH


enum class LottoRank(val matchCount: Int, val bonusResult: BonusResult, val prizeMoney: Int) {
    MISS(0, BONUS_MISMATCH, 0),
    FIFTH(3, BONUS_MISMATCH, 5_000),
    FOURTH(4, BONUS_MISMATCH, 50_000),
    THIRD(5, BONUS_MISMATCH, 1_500_000),
    SECOND(5, BONUS_MATCH, 30_000_000),
    FIRST(6, BONUS_MISMATCH, 2_000_000_000);

    companion object {
        fun convertToRank(matchCount: Int, bonusResult: BonusResult): LottoRank {
            return LottoRank.entries
                .find { rank -> rank.matchCount == matchCount && rank.bonusResult == bonusResult }
                ?: MISS
        }
    }
}