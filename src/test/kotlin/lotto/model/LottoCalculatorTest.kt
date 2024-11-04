package lotto.model

import lotto.model.LottoPrize.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoCalculatorTest {
    private val lottoCalculator = LottoCalculator()

    @Test
    fun `구입 금액 입력 시 구매 가능한 로또 개수를 반환한다`() {
        val lottoAmount = 15_000

        val count = lottoCalculator.calculateLottoCount(lottoAmount)

        assertEquals(15, count)
    }

    @Test
    fun `구매한 로또와 당첨 로또 번호를 가지고 당첨 로또를 반환한다`() {
        val purchasedLottos = listOf(Lotto(listOf(1, 2, 3, 4, 5, 6)), Lotto(listOf(1, 2, 3, 4, 5, 7)))
        val winningLotto = WinningLotto(
            lottoNumber = listOf(1, 2, 3, 4, 5, 6),
            bonusNumber = 7,
        )

        val prizes = lottoCalculator.calculateStatistics(purchasedLottos, winningLotto)

        assertEquals((listOf(FIRST_PRIZE, SECOND_PRIZE)), prizes)
    }

    @Test
    fun `당첨 로또와 로또 구입 금액을 가지고 수익률을 반환한다`() {
        val prizes = listOf(SECOND_PRIZE, FIFTH_PRIZE)
        val lottoAmount = 20_000

        val yield = lottoCalculator.calculateYield(prizes, lottoAmount)

        assertEquals(150_025.0, yield)
    }
}