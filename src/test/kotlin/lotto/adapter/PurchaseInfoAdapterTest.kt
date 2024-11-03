package lotto.adapter

import lotto.domain.model.PurchaseInfo
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class PurchaseInfoAdapterTest {
    @Test
    @DisplayName("구매 정보 - 유효한 입력은 객체 생성")
    fun `makePurchaseInfoModel에 유효한 입력이 들어오면 PurchaseInfo를 생성해야 한다`() {
        val input = "8000"
        val result = PurchaseInfoAdapter.makePurchaseInfoModel(input)

        assertEquals(PurchaseInfo(8000), result)
    }
}