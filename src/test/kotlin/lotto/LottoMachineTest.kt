package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat

class LottoMachineTest {
    private lateinit var lottoMachine: LottoMachine

    @BeforeEach
    fun setUp() {
        lottoMachine = LottoMachine()
    }

    @Test
    fun `로또 구입 금액 입력을 안내할 수 있어야 한다`() {
        assertThat(lottoMachine.guideInputLottoPurchaseAmount()).isEqualTo("구입금액을 입력해 주세요.")
    }

}