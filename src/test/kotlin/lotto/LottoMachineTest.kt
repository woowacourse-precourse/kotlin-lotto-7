package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoMachineTest {

    private val lottoMachine = LottoMachine("3000")

    @Test
    fun `로또 번호와 당첨번호 + 보너스 번호를 비교`() {

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

    @Test
    fun `당첨 결과 확인 테스트`() {
        val winningResult = listOf(
            Pair(4, true),
            Pair(4, false),
            Pair(2, false),
        )

        val expectResult = mapOf(
            Rank.THIRD_RANK to 2,
            Rank.MISS to 1,
        )

        val result = lottoMachine.countPrize(winningResult)

        assertEquals(expectResult, result)
    }
}