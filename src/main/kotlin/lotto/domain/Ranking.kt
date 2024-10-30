package lotto.domain

import lotto.constants.RankingConstants.FIFTH_MSG
import lotto.constants.RankingConstants.FIFTH_PRIZE
import lotto.constants.RankingConstants.FIRST_MSG
import lotto.constants.RankingConstants.FIRST_PRIZE
import lotto.constants.RankingConstants.FOURTH_MSG
import lotto.constants.RankingConstants.FOURTH_PRIZE
import lotto.constants.RankingConstants.SECOND_MSG
import lotto.constants.RankingConstants.SECOND_PRIZE
import lotto.constants.RankingConstants.THIRD_MSG
import lotto.constants.RankingConstants.THIRD_PRIZE

enum class Ranking(val prize: Int, private val matchingMsg: String) {
    FIFTH(FIFTH_PRIZE, FIFTH_MSG), // 5등
    FOURTH(FOURTH_PRIZE, FOURTH_MSG), // 4등
    THIRD(THIRD_PRIZE, THIRD_MSG), // 3등
    SECOND(SECOND_PRIZE, SECOND_MSG), // 2등
    FIRST(FIRST_PRIZE, FIRST_MSG); // 1등


    fun formattedMsg(): String {
        return matchingMsg
    }
}
