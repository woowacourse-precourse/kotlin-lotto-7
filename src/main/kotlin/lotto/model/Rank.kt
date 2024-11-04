package lotto.model

data class Rank(
    val ranking: Ranking,
    var wins: Int = 0,
) {
    fun updateWins() {
        wins += 1
    }
}

enum class Ranking(
    private val winningBall: Int,
    private val bonusBall: Boolean,
    private val prizeMoney: Int,
) {
    FIRST(FIRST_WINNING_BALL_COUNT, false, FIRST_PRIZE_MONEY),
    SECOND(SECOND_WINNING_BALL_COUNT, true, SECOND_PRIZE_MONEY),
    THIRD(THIRD_WINNING_BALL_COUNT, false, THIRD_PRIZE_MONEY),
    FOURTH(FOURTH_WINNING_BALL_COUNT, false, FOURTH_PRIZE_MONEY),
    FIFTH(FIFTH_WINNING_BALL_COUNT, false, FIFTH_PRIZE_MONEY);

    fun getWinningBall() = winningBall
    fun getBonusBall() = bonusBall
    fun getPrizeMoney() = prizeMoney
}

const val FIRST_WINNING_BALL_COUNT = 6
const val SECOND_WINNING_BALL_COUNT = 5
const val THIRD_WINNING_BALL_COUNT = 5
const val FOURTH_WINNING_BALL_COUNT = 4
const val FIFTH_WINNING_BALL_COUNT = 3

const val FIRST_PRIZE_MONEY = 2_000_000_000
const val SECOND_PRIZE_MONEY = 30_000_000
const val THIRD_PRIZE_MONEY = 1_500_000
const val FOURTH_PRIZE_MONEY = 50_000
const val FIFTH_PRIZE_MONEY = 5_000