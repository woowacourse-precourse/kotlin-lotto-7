package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RevenueTest {

    @ParameterizedTest
    @ValueSource(ints = [0, -10])
    fun `구매금액이 양수가 아닌 경우 예외를 발생시킨다`(purchaseAmount: Int) {
        // When
        val exception = assertThrows<IllegalArgumentException> {
            Revenue(purchaseAmount, 0L)
        }

        // Then
        assertEquals(AMOUNT_POSITIVE_ERROR_MESSAGE, exception.message)
    }

    @Test
    fun `구매금액이 1000원 단위가 아닌 경우 예외를 발생시킨다`() {
        // Given
        val purchaseAmount = 1111

        // When
        val exception = assertThrows<IllegalArgumentException> {
            Revenue(purchaseAmount, 0L)
        }

        // Then
        assertEquals(THOUSAND_UNIT_ERROR_MESSAGE, exception.message)
    }

    @Test
    fun `당첨금액이 음수인 경우 예외를 발생시킨다`() {
        // Given
        val totalPrize = -10L

        // When
        val exception = assertThrows<IllegalArgumentException> {
            Revenue(1000, totalPrize)
        }

        // Then
        assertEquals(TOTAL_PRIZE_ERROR_MESSAGE, exception.message)
    }

    @Test
    fun `올바른 구매금액과 당첨금액인 경우 예외를 발생시키지 않는다`() {
        // Given
        val purchaseAmount = 2000
        val totalPrize = 10000L

        // When & Then
        assertDoesNotThrow {
            Revenue(purchaseAmount, totalPrize)
        }
    }

    @Test
    fun `올바른 구매금액과 당첨금액인 경우 올바른 수익률을 반환한다 `() {
        // Given
        val purchaseAmount = 2000
        val totalPrize = 10000L

        // When & Then
        val revenue = Revenue(purchaseAmount, totalPrize).getRevenueRate()

        assertEquals(500.0, revenue)
    }

    companion object {
        private const val AMOUNT_POSITIVE_ERROR_MESSAGE = "구매금액은 양수를 입력해야 합니다."
        private const val THOUSAND_UNIT_ERROR_MESSAGE = "구매금액은 1,000원 단위로 입력해야 합니다."
        private const val TOTAL_PRIZE_ERROR_MESSAGE = "당첨금액은 음수 일 수 없습니다."
    }
}
