package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoAmountTest {

    @Test
    fun `구입 금액이 1,000원 단위가 아닐 경우 예외가 발생한다`() {
        val lottoAmount = 1_500

        assertThrows<IllegalArgumentException> {
            LottoAmount(lottoAmount)
        }
    }
}