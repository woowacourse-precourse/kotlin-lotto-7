package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoAmountTest {
    private val lottoAmount = LottoAmount("2000")

    @Test
    fun `구매금액만큼 로또 개수를 반환한다`() {
        val result = lottoAmount.purchaseCount
        val expected = 2

        assertEquals(expected, result)
    }

    @Test
    fun `로또개수만큼 로또번호를 생성한다`() {
        val purchaseCount = 2
        val lottos = lottoAmount.lottos

        assertEquals(purchaseCount, lottos.size)
    }

    @Test
    fun `구매금액이 1000원 단위가 아니면 예외를 발생시킨다`() {
        assertThrows<IllegalArgumentException> {
            LottoAmount("2001")
        }
    }
}
