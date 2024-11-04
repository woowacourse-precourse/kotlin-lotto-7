package lotto.data.random

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoNumberGeneratorImplKtTest {
    @Test
    fun `pickLottoNumbers는 6개의 숫자를 생성`() {
        // act
        val lottoNumbers = pickLottoNumbers()

        // assert
        assertThat(lottoNumbers.size).isEqualTo(6)
    }

    @Test
    fun `pickLottoNumbers는 중복되지 않는 숫자를 생성`() {
        // act
        val lottoNumbers = pickLottoNumbers()

        // assert
        assertThat(lottoNumbers.size).isEqualTo(lottoNumbers.distinct().size)
    }
}
