package lotto.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import lotto.util.Constants

class LottoMachineTest {

    private val lottoMachine = LottoMachine()

    @Test
    fun `구입 금액이 0일 때 로또를 구입하면 빈 리스트를 반환한다`() {
        val purchaseAmount = 0
        val lottos = lottoMachine.purchaseLottos(purchaseAmount)

        assertTrue(lottos.isEmpty())
    }

    @Test
    fun `구입 금액이 로또 가격의 배수일 때 로또 수를 정확히 계산한다`() {
        val purchaseAmount = Constants.LOTTO_PRICE * 3
        val lottos = lottoMachine.purchaseLottos(purchaseAmount)

        assertEquals(3, lottos.size)
    }
}