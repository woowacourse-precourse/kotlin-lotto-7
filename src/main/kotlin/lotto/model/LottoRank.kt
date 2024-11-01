package lotto.model

import lotto.util.Constants.LOTTO_RANK_FIFTH_WINNING_AMOUNT
import lotto.util.Constants.LOTTO_RANK_FIRST_WINNING_AMOUNT
import lotto.util.Constants.LOTTO_RANK_FOURTH_WINNING_AMOUNT
import lotto.util.Constants.LOTTO_RANK_NO_WIN_WINNING_AMOUNT
import lotto.util.Constants.LOTTO_RANK_SECOND_WINNING_AMOUNT
import lotto.util.Constants.LOTTO_RANK_THIRD_WINNING_AMOUNT

data class LottoRank(
    val rank: Rank,
    val winningAmount: Int
) {

    enum class Rank {
        FIRST, SECOND, THIRD, FOURTH, FIFTH, NO_WIN
    }

    companion object {
        private val winningAmounts = mapOf(
            Rank.FIRST to LOTTO_RANK_FIRST_WINNING_AMOUNT,
            Rank.SECOND to LOTTO_RANK_SECOND_WINNING_AMOUNT,
            Rank.THIRD to LOTTO_RANK_THIRD_WINNING_AMOUNT,
            Rank.FOURTH to LOTTO_RANK_FOURTH_WINNING_AMOUNT,
            Rank.FIFTH to LOTTO_RANK_FIFTH_WINNING_AMOUNT,
            Rank.NO_WIN to LOTTO_RANK_NO_WIN_WINNING_AMOUNT
        )

        fun determineRank(matchCount: Int, isMatchedBonus: Boolean): LottoRank {
            val rank = when (matchCount) {
                6 -> Rank.FIRST
                5 -> if (isMatchedBonus) Rank.SECOND else Rank.THIRD
                4 -> Rank.FOURTH
                3 -> Rank.FIFTH
                else -> Rank.NO_WIN
            }

            return LottoRank(rank, winningAmounts[rank] ?: LOTTO_RANK_NO_WIN_WINNING_AMOUNT)
        }
    }
}