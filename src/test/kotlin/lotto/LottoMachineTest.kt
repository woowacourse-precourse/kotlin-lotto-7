package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoMachineTest {

    @Test
    fun `로또 번호와 당첨번호 + 보너스 번호를 비교`() {
        val lottoMachine = LottoMachine("3000")

        val lottos = listOf(
            Lotto(listOf(1, 3, 10, 26, 41, 45)),
            Lotto(listOf(1, 5, 9, 21, 26, 41)),
            Lotto(listOf(1, 2, 9, 25, 40, 44)),
        )
        val winningNumber = WinningNumber("1,3,9,21,41,45")
        val bonusNumber = BonusNumber("10", winningNumber)

        val result = lottoMachine.winningLotteryResult(lottos, bonusNumber)

        val expectResult = listOf(
            Pair(4, true),
            Pair(4, false),
            Pair(2, false),
        )

        assertEquals(expectResult, result)
    }
}