package lotto.domain

import lotto.constants.RankingConstants.FIFTH_MESSAGE
import lotto.constants.RankingConstants.FIFTH_PRIZE
import lotto.constants.RankingConstants.FIRST_MESSAGE
import lotto.constants.RankingConstants.FIRST_PRIZE
import lotto.constants.RankingConstants.FOURTH_MESSAGE
import lotto.constants.RankingConstants.FOURTH_PRIZE
import lotto.constants.RankingConstants.SECOND_MESSAGE
import lotto.constants.RankingConstants.SECOND_PRIZE
import lotto.constants.RankingConstants.THIRD_MESSAGE
import lotto.constants.RankingConstants.THIRD_PRIZE

enum class Ranking(val prize: Int, private val matchingMsg: String) {
    FIFTH(FIFTH_PRIZE, FIFTH_MESSAGE),
    FOURTH(FOURTH_PRIZE, FOURTH_MESSAGE),
    THIRD(THIRD_PRIZE, THIRD_MESSAGE),
    SECOND(SECOND_PRIZE, SECOND_MESSAGE),
    FIRST(FIRST_PRIZE, FIRST_MESSAGE);


    fun formattedMessage(): String {
        return matchingMsg
    }
}
