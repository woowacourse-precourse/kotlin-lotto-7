package lotto.model

import lotto.util.*

enum class LottoMatchRank(val matchCount: Int, val prize: Int) {
    FIFTH(FIFTH_MATCH_COUNT, FIFTH_PRIZE),
    FOURTH(FOURTH_MATCH_COUNT, FOURTH_PRIZE),
    THIRD(THIRD_MATCH_COUNT, THIRD_PRIZE),
    SECOND(SECOND_MATCH_COUNT, SECOND_PRIZE),
    FIRST(FIRST_MATCH_COUNT, FIRST_PRIZE)
}