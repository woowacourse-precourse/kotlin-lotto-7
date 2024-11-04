package lotto.model

import lotto.util.Constants

enum class Prize(val matchCount: Int, val prizeMoney: Int, val bonusMatch: Boolean = false) {
    FIRST(6, Constants.FIRST_PRIZE_MONEY),
    SECOND(5, Constants.SECOND_PRIZE_MONEY, true),
    THIRD(5, Constants.THIRD_PRIZE_MONEY),
    FOURTH(4, Constants.FOURTH_PRIZE_MONEY),
    FIFTH(3, Constants.FIFTH_PRIZE_MONEY),
    NONE(0, 0);
}