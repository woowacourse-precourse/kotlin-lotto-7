package lotto.model

import lotto.util.Constants.LOTTO_RANK_FIFTH_WINNING_AMOUNT
import lotto.util.Constants.LOTTO_RANK_FIRST_WINNING_AMOUNT
import lotto.util.Constants.LOTTO_RANK_FOURTH_WINNING_AMOUNT
import lotto.util.Constants.LOTTO_RANK_NO_WIN_WINNING_AMOUNT
import lotto.util.Constants.LOTTO_RANK_SECOND_WINNING_AMOUNT
import lotto.util.Constants.LOTTO_RANK_THIRD_WINNING_AMOUNT
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoRankTest {

    @Test
    fun `1등일 때 2,000,000,000원을 반환한다`() {
        val result = LottoRank.determineRank(6, false)
        assertEquals(LottoRank.Rank.FIRST, result.rank)
        assertEquals(LOTTO_RANK_FIRST_WINNING_AMOUNT, result.winningAmount)
    }

    @Test
    fun `2등일 때 30,000,000원을 반환한다`() {
        val result = LottoRank.determineRank(5, true)
        assertEquals(LottoRank.Rank.SECOND, result.rank)
        assertEquals(LOTTO_RANK_SECOND_WINNING_AMOUNT, result.winningAmount)
    }

    @Test
    fun `3등일 때 1,500,000원을 반환한다`() {
        val result = LottoRank.determineRank(5, false)
        assertEquals(LottoRank.Rank.THIRD, result.rank)
        assertEquals(LOTTO_RANK_THIRD_WINNING_AMOUNT, result.winningAmount)
    }

    @Test
    fun `4등일 때 50,000원을 반환한다`() {
        val result = LottoRank.determineRank(4, false)
        assertEquals(LottoRank.Rank.FOURTH, result.rank)
        assertEquals(LOTTO_RANK_FOURTH_WINNING_AMOUNT, result.winningAmount)
    }

    @Test
    fun `5등일 때 5,000원을 반환한다`() {
        val result = LottoRank.determineRank(3, false)
        assertEquals(LottoRank.Rank.FIFTH, result.rank)
        assertEquals(LOTTO_RANK_FIFTH_WINNING_AMOUNT, result.winningAmount)
    }

    @Test
    fun `당첨되지 않을 때`() {
        val result = LottoRank.determineRank(0, false)
        assertEquals(LottoRank.Rank.NO_WIN, result.rank)
        assertEquals(LOTTO_RANK_NO_WIN_WINNING_AMOUNT, result.winningAmount)
    }
}
