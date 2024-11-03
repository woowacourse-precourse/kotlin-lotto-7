package lotto.domain.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class PrizeTest {
    @Test
    @DisplayName("상 - 1등")
    fun `6개 번호가 일치하면 1등이다`() {
        val matchingNumberCount = 6
        val matchingBonusNumber = false
        val prize = Prize.getPrize(matchingNumberCount, matchingBonusNumber)

        assertEquals(Prize.FIRST, prize)
    }

    @Test
    @DisplayName("상 - 2등")
    fun `5개 번호와 보너스 번호가 일치하면 2등이다`() {
        val matchingNumberCount = 5
        val matchingBonusNumber = true
        val prize = Prize.getPrize(matchingNumberCount, matchingBonusNumber)

        assertEquals(Prize.SECOND, prize)
    }

    @Test
    @DisplayName("상 - 3등")
    fun `5개 번호만 일치하면 3등이다`() {
        val matchingNumberCount = 5
        val matchingBonusNumber = false
        val prize = Prize.getPrize(matchingNumberCount, matchingBonusNumber)

        assertEquals(Prize.THIRD, prize)
    }

    @Test
    @DisplayName("상 - 4등")
    fun `4개 번호가 일치하면 4등이다`() {
        val matchingNumberCount = 4
        val matchingBonusNumber = false
        val prize = Prize.getPrize(matchingNumberCount, matchingBonusNumber)

        assertEquals(Prize.FOURTH, prize)
    }

    @Test
    @DisplayName("상 - 5등")
    fun `3개 번호가 일치하면 5등이다`() {
        val matchingNumberCount = 3
        val matchingBonusNumber = false
        val prize = Prize.getPrize(matchingNumberCount, matchingBonusNumber)

        assertEquals(Prize.FIFTH, prize)
    }

    @Test
    @DisplayName("상 - 없음")
    fun `일치하는 번호가 2개 이하이면 아무것도 없다`() {
        val matchingNumberCount = 2
        val matchingBonusNumber = false
        val prize = Prize.getPrize(matchingNumberCount, matchingBonusNumber)

        assertEquals(Prize.NONE, prize)
    }

    @Test
    @DisplayName("상 - 통화변환")
    fun `prizeAmount는 한국 통화 형식으로 변환되어야 한다`() {
        val prize = Prize.FIRST
        val formattedAmount = prize.prizeAmount

        assertEquals("2,000,000,000", formattedAmount)
    }
}
