package lotto.model

import lotto.util.Constants
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoGameTest {

    private val lottoGame = LottoGame()

    @Test
    fun `로또 번호를 생성할 때 지정된 개수의 로또를 생성해야 한다`() {
        val lottoCount = 5
        val lottos = lottoGame.generateLotto(lottoCount)

        assertEquals(lottoCount, lottos.size)
        lottos.forEach { lotto ->
            assertEquals(6, lotto.getNumbers().size)
            lotto.getNumbers().forEach { number ->
                assert(number in 1..45) { "번호는 1에서 45 사이여야 합니다." }
            }
        }
    }

    @Test
    fun `로또 결과를 계산할 때 당첨금이 올바르게 계산되어야 한다`() {
        val lottos = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(1, 2, 3, 4, 5, 7)),
            Lotto(listOf(1, 2, 3, 4, 5, 9)),
            Lotto(listOf(1, 2, 3, 4, 11, 12)),
            Lotto(listOf(1, 2, 3, 16, 17, 18)),
            Lotto(listOf(19, 20, 21, 22, 23, 24))
        )

        val winningNumbers = listOf(1, 2, 3, 4, 5,6)
        val bonusNumber = 7

        val result: LottoResult = lottoGame.calculateResult(lottos, winningNumbers, bonusNumber)

        val expectedPrizeCounts = mapOf(
            Prize.FIRST to 1,
            Prize.SECOND to 1,
            Prize.THIRD to 1,
            Prize.FOURTH to 1,
            Prize.FIFTH to 1,
            Prize.NONE to 1
        )

        assertEquals(expectedPrizeCounts, result.prizeCounts)
        assertEquals(2031555000, result.totalPrize)
        assertEquals(lottos.size * Constants.LOTTO_UNIT_PRICE, result.purchaseAmount)
    }
}