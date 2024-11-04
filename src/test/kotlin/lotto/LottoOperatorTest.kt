package lotto

import lotto.domain.Lotto
import lotto.domain.LottoOperator
import org.junit.jupiter.api.Test

class LottoOperatorTest {

    @Test
    fun `로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다`() {
        val purchasePrice = 10_000
        val lottoPrice = Lotto.PRICE
        val expectedLottoCount = purchasePrice / lottoPrice
        assert(LottoOperator.buy(10_000).size == expectedLottoCount)
    }
}