package lotto

import lotto.Controller.LotteryMachine
import lotto.Model.User
import lotto.Util.Prize
import lotto.Util.ResultCalculator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ResultCalculatorTest {
    @Test
    fun `로또 번호와 당첨 번호를 비교해 당첨 등수를 올바르게 계산`() {
        val user = User(1)
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        LotteryMachine.setWinningLotto(winningNumbers, bonusNumber)

        // prizeResult에 Prize와 해당 등수에 당첨된 로또의 개수가 포함된 map이 저장
        val prizeResult = ResultCalculator().calculateResults(user)
        prizeResult.forEach { (prize, count) ->
            when (prize) {
                Prize.FIRST -> assertThat(count).isEqualTo(1) // Prize.FIRST인 경우 count가 1이어야 한다.
                else -> assertThat(count).isEqualTo(0)
            }
        }
    }

    @Test
    fun `사용자의 수익률을 올바르게 계산`() {
        val user = User(3)
        user.addProfit(2000) // 임의의 당첨 금액

        val profitRate = ResultCalculator().calculateProfitRate(user)
        assertThat(profitRate).isEqualTo((2000.0 / (3 * 1000)) * 100)
    }
}