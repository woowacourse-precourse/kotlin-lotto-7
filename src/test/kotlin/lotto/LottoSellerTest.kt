package lotto

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Test

class LottoSellerTest {
    @Test
    fun `구입 금액이 1000원 미만이면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            LottoSeller(999)
        }
    }
}