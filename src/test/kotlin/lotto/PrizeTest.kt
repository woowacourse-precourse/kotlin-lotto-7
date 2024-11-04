package lotto

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class PrizeTest {

    @Test
    fun `수익률 계산 테스트`() {
        val prize = Prize(second = 1, third = 1, fourth = 1).getPrizeMoney()

        val expectResult = 31550000.0

        Assertions.assertEquals(expectResult, prize)
    }
}