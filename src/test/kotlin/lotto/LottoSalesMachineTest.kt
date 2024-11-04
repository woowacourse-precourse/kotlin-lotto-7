package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat

class LottoSalesMachineTest {
    private lateinit var lottoSalesMachine: LottoSalesMachine

    @BeforeEach
    fun setUp() {
        lottoSalesMachine = LottoSalesMachine()
    }

    @Test
    fun `로또 구입 금액 입력을 안내할 수 있어야 한다`() {
        assertThat(lottoSalesMachine.guideInputLottoPurchaseAmount()).isEqualTo("구입금액을 입력해 주세요.")
    }

    @Test
    fun `1000으로 나누어 떨어지지 않는 값이 구입 금액이면 예외 처리한다`() {
        val exception = assertThrows<IllegalArgumentException> {
            lottoSalesMachine.purchase(7500)
        }

        assertThat(exception.message).contains(ErrorMessage.INPUT_AMOUNT_ERROR.getMessage())
    }
}