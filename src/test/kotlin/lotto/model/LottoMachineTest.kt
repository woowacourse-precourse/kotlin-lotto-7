package lotto.model

import org.junit.jupiter.api.Test

class LottoMachineTest {
    @Test
    fun `구매 금액만큼 로또를 만든다`() {
        val issueLottos = LottoMachine.issueLottos(PurchaseAmount(8000))
        assert(issueLottos.size == 8)
    }
}
