package lotto

import lotto.Controller.LotteryMachine
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LotteryMachineTest {
    @Test
    fun `구매하는 로또 수량만큼 로또를 발행한다`() {
        val lottoList = LotteryMachine.generateLottos(3)
        assertThat(lottoList).hasSize(3)
        lottoList.forEach { lotto ->
            assertThat(lotto.getNumbers()).hasSize(6)
            assertThat(lotto.getNumbers().distinct().size).isEqualTo(6)
        }
    }
}