package lotto.model

import lotto.constants.Constants.MATCH_COUNT_FIFTH
import lotto.constants.Constants.MATCH_COUNT_FIRST
import lotto.constants.Constants.MATCH_COUNT_FOURTH
import lotto.constants.Constants.MATCH_COUNT_SECOND
import lotto.constants.Constants.MATCH_COUNT_THIRD
import lotto.constants.Constants.PRIZE_FIFTH
import lotto.constants.Constants.PRIZE_FIRST
import lotto.constants.Constants.PRIZE_FOURTH
import lotto.constants.Constants.PRIZE_SECOND
import lotto.constants.Constants.PRIZE_THIRD

enum class Rank(val matchCount: Int, val prize: Int) {
    FIRST(MATCH_COUNT_FIRST, PRIZE_FIRST),
    SECOND(MATCH_COUNT_SECOND, PRIZE_SECOND),
    THIRD(MATCH_COUNT_THIRD, PRIZE_THIRD),
    FOURTH(MATCH_COUNT_FOURTH, PRIZE_FOURTH),
    FIFTH(MATCH_COUNT_FIFTH, PRIZE_FIFTH),
}