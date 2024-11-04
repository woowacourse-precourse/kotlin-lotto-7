package lotto.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoNumberMatcherTest {

    private val lottoNumberMatcher = LottoNumberMatcher()

    @Test
    fun `로또 번호 당첨 번호와 비교했을 때 3개 일치`() {
        val count = lottoNumberMatcher.matchWithWinningNumbers(lottoTestData, winningNumbersTestData)
        assertEquals(THREE_MATCHES, count)
    }

    @Test
    fun `로또 번호에 보너스 번호 포함`() {
        val hasBonusNumber = lottoNumberMatcher.matchWithBonusNumber(lottoTestData, BONUS_NUMBER)
        assertEquals(HAS_BONUS_NUMBER, hasBonusNumber)
    }

    companion object {
        private val lottoTestData = Lotto(listOf(1,2,3,4,5,6))
        private val winningNumbersTestData = listOf(1,2,3,10,11,12)
        private const val THREE_MATCHES = 3
        private const val BONUS_NUMBER = 6
        private const val HAS_BONUS_NUMBER = true
    }
}