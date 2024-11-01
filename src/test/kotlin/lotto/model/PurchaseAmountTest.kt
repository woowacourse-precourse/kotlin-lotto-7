package lotto.model

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PurchaseAmountTest {

    @Test
    fun `구입 금액이 정상적으로 설정되어야 한다`() {
        val purchaseAmount = PurchaseAmount()
        val amountInput = "3000"

        purchaseAmount.setPurchaseAmount(amountInput)

        assertEquals(3000, purchaseAmount.getPurchaseAmount())
    }

    @Test
    fun `구입 금액이 숫자가 아닐 경우 예외가 발생해야 한다`() {
        val purchaseAmount = PurchaseAmount()
        val amountInput = "abc"

        assertThatThrownBy { purchaseAmount.setPurchaseAmount(amountInput) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(PurchaseAmount.NOT_NUMERIC_MESSAGE)
    }

    @Test
    fun `구입 금액이 1000원 미만일 경우 예외가 발생해야 한다`() {
        val purchaseAmount = PurchaseAmount()
        val amountInput = "500"

        assertThatThrownBy { purchaseAmount.setPurchaseAmount(amountInput) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(PurchaseAmount.LESS_THAN_MINIMUM_MESSAGE)
    }

    @Test
    fun `구입 금액이 1000원 단위가 아닐 경우 예외가 발생해야 한다`() {
        val purchaseAmount = PurchaseAmount()
        val amountInput = "2500"

        assertThatThrownBy { purchaseAmount.setPurchaseAmount(amountInput) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(PurchaseAmount.NOT_MULTIPLE_OF_THOUSAND_MESSAGE)
    }
}
