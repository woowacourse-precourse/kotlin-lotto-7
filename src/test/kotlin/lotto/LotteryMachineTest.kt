package lotto

import lotto.Controller.LotteryMachine
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LotteryMachineTest {
    @Test
    fun `구매하는 로또 수량만큼 로또를 발행한다`() {
        val purchasedLottos = LotteryMachine.generateLottos(3)
        assertThat(purchasedLottos).hasSize(3)
        purchasedLottos.forEach { lotto ->
            assertThat(lotto.getNumbers()).hasSize(6)
            assertThat(lotto.getNumbers().distinct().size).isEqualTo(6)
        }
    }

    @Test
    fun `당첨 번호와 보너스 번호가 올바르게 설정된다`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        LotteryMachine.setWinningLotto(winningNumbers, bonusNumber)
        assertThat(LotteryMachine.winningNumbers).containsExactlyElementsOf(winningNumbers)
        assertThat(LotteryMachine.bonusNumber).isEqualTo(bonusNumber)
    }
}