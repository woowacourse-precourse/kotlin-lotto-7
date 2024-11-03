package lotto.domain.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class PurchaseInfoTest {
    @Test
    @DisplayName("구매정보 - 티켓 수 계산")
    fun `구매 금액에 따라 티켓 수가 올바르게 계산되어야 한다`() {
        val purchaseAmount = 8000
        val purchaseInfo = PurchaseInfo(purchaseAmount)

        assertEquals(8, purchaseInfo.numberOfTickets)
    }
}