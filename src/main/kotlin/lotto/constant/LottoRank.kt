package lotto.constant

import lotto.constant.BonusResult.ANY
import lotto.constant.BonusResult.BONUS_MATCH
import lotto.constant.BonusResult.BONUS_MISMATCH


enum class LottoRank(val matchCount: Int, val bonusResult: BonusResult, val prizeMoney: Int) {
    MISS(0, ANY, 0),
    FIRST(6, ANY, 2_000_000_000),
    SECOND(5, BONUS_MATCH, 30_000_000),
    THIRD(5, BONUS_MISMATCH, 1_500_000),
    FOURTH(4, ANY, 50_000),
    FIFTH(3, ANY, 5_000);

    companion object {

    }
}