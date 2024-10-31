package lotto.domain

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class LottoNumberKtTest {

    @Test
    fun `랜덤 숫자의 범위가 1-45인지 테스트`() {
        val lottoNumbers = getLottoNumbers()
        assertTrue(lottoNumbers.all { it in 1..45 })
    }
}