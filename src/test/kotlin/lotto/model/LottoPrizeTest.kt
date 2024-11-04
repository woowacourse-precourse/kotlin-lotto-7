package lotto.model

import lotto.model.LottoPrize.SECOND_PRIZE
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoPrizeTest {

    @Test
    fun `로또 맞은 개수와 보너스 번호 일치 여부를 통해 당첨 로또의 당첨 등수를 반환한다`() {
        val matchingCount = 5
        val isMatchingBonusNumber = true

        val prize = LottoPrize.fromMatchingCount(
            matchingCount = matchingCount,
            isMatchingBonusNumber = isMatchingBonusNumber,
        )

        assertEquals(SECOND_PRIZE, prize)
    }

    @Test
    fun `로또 맞은 개수가 0~6 사이가 아닐 경우 예외를 발생한다`() {
        val matchingCount = 10
        val isMatchingBonusNumber = false

        assertThrows<IllegalArgumentException> {
            LottoPrize.fromMatchingCount(matchingCount, isMatchingBonusNumber)
        }
    }
}