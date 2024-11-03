package lotto.domain

import lotto.constants.LottoConstants.LOTTO_NUMBER_RANGE
import lotto.constants.LottoConstants.MAX_LOTTO_NUMBER
import lotto.constants.LottoConstants.MIN_LOTTO_NUMBER
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class LottoNumberKtTest {
    private val lottoNumbers = getLottoNumbers()

    @Test
    fun `랜덤 숫자의 범위가 1-45인지 테스트`() {
        assertTrue(lottoNumbers.all { it in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER })
    }

    @Test
    fun `랜덤 숫자의 개수가 6개인지 테스트`() {
        assertTrue(lottoNumbers.size == LOTTO_NUMBER_RANGE)
    }

    @Test
    fun `랜덤숫자가 중복되는지 테스트`() {
        assertTrue(lottoNumbers.size == lottoNumbers.toSet().size)
    }
}
