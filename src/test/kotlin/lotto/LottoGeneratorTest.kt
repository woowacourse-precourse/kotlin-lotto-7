package lotto

import lotto.util.LottoConstants
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoGeneratorTest {
    @Test
    fun `구입 금액이 1,000원 미만이면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            LottoGenerator(500)
        }
    }

    @Test
    fun `구입 금액이 1,000원으로 나누어 떨어지지 않으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            LottoGenerator(1500)
        }
    }

    @Test
    fun `구입 금액에 따라 정확한 개수의 로또를 반환한다`() {
        val purchasePrice = 2000
        val expectedSize = purchasePrice / LottoConstants.PRICE
        val lottoGenerator = LottoGenerator(purchasePrice)
        val lottoList = lottoGenerator.generate()
        val actualSize = lottoList.size

        assertEquals(expectedSize, actualSize)
    }
}