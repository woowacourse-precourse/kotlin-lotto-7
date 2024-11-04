package lotto.model

import lotto.util.Constants.LOTTO_RANK_FIFTH_WINNING_AMOUNT
import lotto.util.Constants.LOTTO_RANK_FIRST_WINNING_AMOUNT
import lotto.util.Constants.LOTTO_RANK_FOURTH_WINNING_AMOUNT
import lotto.util.Constants.LOTTO_RANK_NO_WIN_WINNING_AMOUNT
import lotto.util.Constants.LOTTO_RANK_SECOND_WINNING_AMOUNT
import lotto.util.Constants.LOTTO_RANK_THIRD_WINNING_AMOUNT

enum class LottoRank(val matchCount: Int, val winningAmount: Int) {
    FIRST(6, LOTTO_RANK_FIRST_WINNING_AMOUNT),
    SECOND(5, LOTTO_RANK_SECOND_WINNING_AMOUNT),
    THIRD(5, LOTTO_RANK_THIRD_WINNING_AMOUNT),
    FOURTH(4, LOTTO_RANK_FOURTH_WINNING_AMOUNT),
    FIFTH(3, LOTTO_RANK_FIFTH_WINNING_AMOUNT),
    NO_WIN(0, LOTTO_RANK_NO_WIN_WINNING_AMOUNT);

    companion object {
        fun determineRank(matchCount: Int, isMatchedBonus: Boolean): LottoRank {
            return when {
                matchCount == 6 -> FIRST
                matchCount == 5 && isMatchedBonus -> SECOND
                matchCount == 5 -> THIRD
                matchCount == 4 -> FOURTH
                matchCount == 3 -> FIFTH
                else -> NO_WIN
            }
        }
    }
}