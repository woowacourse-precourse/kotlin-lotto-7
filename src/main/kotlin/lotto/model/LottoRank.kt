package lotto.model

import lotto.utils.Constants

enum class LottoRank(val matchCount: Int, val prize: Int) {
    FIRST(Constants.SIX, Constants.FIRST_PRIZE),
    SECOND(Constants.FIVE, Constants.SECOND_PRIZE),
    THIRD(Constants.FIVE, Constants.THIRD_PRIZE),
    FOURTH(Constants.FOUR, Constants.FOURTH_PRIZE),
    FIFTH(Constants.THREE, Constants.FIFTH_PRIZE),
    NONE(Constants.ZERO, Constants.NO_PRIZE);
}