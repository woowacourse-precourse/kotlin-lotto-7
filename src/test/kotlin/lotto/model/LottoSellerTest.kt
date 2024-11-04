package lotto.model

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class LottoSellerTest {
    @Test
    fun `구입 금액이 1000원 미만이면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            LottoSeller(999)
        }
    }

    @Test
    fun `구입 금액이 1000원 단위가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            LottoSeller(1500)
        }
    }

    @Test
    fun `로또 구매 개수를 반환한다`() {
        val lottoSeller = LottoSeller(5000)
        assertThat(lottoSeller.lottoCount).isEqualTo(5)
    }

    @Test
    fun `로또를 판매한다`() {
        val lottoSeller = LottoSeller(5000)
        assertThat(lottoSeller.sell().size).isEqualTo(5)
    }
}