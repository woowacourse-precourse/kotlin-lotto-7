package lotto.model

import lotto.util.ExceptionConstants.ERROR_MESSAGE_PURCHASE_AMOUNT_LESS_THAN_MINIMUM
import lotto.util.ExceptionConstants.ERROR_MESSAGE_PURCHASE_AMOUNT_NOT_MULTIPLE
import lotto.util.ExceptionConstants.ERROR_MESSAGE_PURCHASE_AMOUNT_TYPE
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
            .hasMessage(ERROR_MESSAGE_PURCHASE_AMOUNT_TYPE)
    }

    @Test
    fun `구입 금액이 1000원 미만일 경우 예외가 발생해야 한다`() {
        val purchaseAmount = PurchaseAmount()
        val amountInput = "500"

        assertThatThrownBy { purchaseAmount.setPurchaseAmount(amountInput) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(ERROR_MESSAGE_PURCHASE_AMOUNT_LESS_THAN_MINIMUM)
    }

    @Test
    fun `구입 금액이 1000원 단위가 아닐 경우 예외가 발생해야 한다`() {
        val purchaseAmount = PurchaseAmount()
        val amountInput = "2500"

        assertThatThrownBy { purchaseAmount.setPurchaseAmount(amountInput) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(ERROR_MESSAGE_PURCHASE_AMOUNT_NOT_MULTIPLE)
    }
}
