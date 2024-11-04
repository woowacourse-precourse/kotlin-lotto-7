package lotto.model

import lotto.util.constant.LottoRules
import lotto.util.constant.OutputConst

enum class LottoRank(
    val rankNumber: Int,
    val prizeMoney: Int,
    val displayName: String? = null
) {
    FIRST(
        rankNumber = LottoRules.RANK_FIRST,
        prizeMoney = LottoRules.FIRST_PRIZE_MONEY,
        displayName = OutputConst.SIX_MATCHED
    ),
    SECOND(
        rankNumber = LottoRules.RANK_SECOND,
        prizeMoney = LottoRules.SECOND_PRIZE_MONEY,
        displayName = OutputConst.FIVE_MATCHED_WITH_BONUS
    ),
    THIRD(
        rankNumber = LottoRules.RANK_THIRD,
        prizeMoney = LottoRules.THIRD_PRIZE_MONEY,
        displayName = OutputConst.FIVE_MATCHED
    ),
    FOURTH(
        rankNumber = LottoRules.RANK_FOURTH,
        prizeMoney = LottoRules.FOURTH_PRIZE_MONEY,
        displayName = OutputConst.FOUR_MATCHED
    ),
    FIFTH(
        rankNumber = LottoRules.RANK_FIFTH,
        prizeMoney = LottoRules.FIFTH_PRIZE_MONEY,
        displayName = OutputConst.THREE_MATCHED
    ),
    OUT_OF_RANK(
        rankNumber = LottoRules.OUT_OF_RANK,
        prizeMoney = LottoRules.OUT_OF_RANK,
    );

    companion object {
        fun fromMatchedCount(matchedCount: Int, bonusMatched: Boolean = false): LottoRank {
            return when (matchedCount) {
                LottoRules.MATCHED_SIX -> FIRST
                LottoRules.MATCHED_FIVE -> if (bonusMatched) SECOND else THIRD
                LottoRules.MATCHED_FOUR -> FOURTH
                LottoRules.MATCHED_THREE -> FIFTH
                else -> OUT_OF_RANK
            }
        }
    }
}