package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PurchaseTest {

    @Test
    fun `구매 금액이 숫자가 아닌 경우 예외를 발생시킨다`() {
        // Given
        val inputAmount = "삼천원"

        // When
        val exception = assertThrows<IllegalArgumentException> {
            Purchase(inputAmount)
        }

        //Then
        assertEquals(PARSE_AMOUNT_ERROR_MESSAGE, exception.message)
    }

    @Test
    fun `구매 금액이 빈 문자열인 경우 예외를 발생시킨다`() {
        // Given
        val inputAmount = ""

        // When
        val exception = assertThrows<IllegalArgumentException> {
            Purchase(inputAmount)
        }

        //Then
        assertEquals(PARSE_AMOUNT_ERROR_MESSAGE, exception.message)
    }

    @Test
    fun `구매 금액이 음수인 경우 예외를 발생시킨다`() {
        // Given
        val inputAmount = "-1000"

        // When
        val exception = assertThrows<IllegalArgumentException> {
            Purchase(inputAmount)
        }

        //Then
        assertEquals(AMOUNT_POSITIVE_ERROR_MESSAGE, exception.message)
    }

    @Test
    fun `구매 금액이 1,000원 단위가 아닌 경우 예외를 발생시킨다`() {
        // Given
        val inputAmount = "11500"

        // When
        val exception = assertThrows<IllegalArgumentException> {
            Purchase(inputAmount)
        }

        //Then
        assertEquals(THOUSAND_UNIT_ERROR_MESSAGE, exception.message)
    }

    @Test
    fun `올바른 구매 금액이 주어진 경우 올바른 구매 금액을 반환한다`() {
        // Given
        val inputAmount = "11000"

        // When
        val lottoCount = Purchase(inputAmount).amount

        // Then
        assertThat(lottoCount).isEqualTo(11000)
    }

    @Test
    fun `올바른 구매 금액이 주어진 경우 구입 금액에 따른 구매 횟수를 반환한다`() {
        // Given
        val inputAmount = "11000"

        // When
        val lottoPurchaseCount = Purchase(inputAmount).getLottoCount()

        // Then
        assertThat(lottoPurchaseCount).isEqualTo(11)
    }

    companion object {
        private const val PARSE_AMOUNT_ERROR_MESSAGE = "구매금액은 숫자를 입력해야 합니다."
        private const val AMOUNT_POSITIVE_ERROR_MESSAGE = "구매금액은 양수를 입력해야 합니다."
        private const val THOUSAND_UNIT_ERROR_MESSAGE = "구매금액은 1,000원 단위로 입력해야 합니다."
    }

}
