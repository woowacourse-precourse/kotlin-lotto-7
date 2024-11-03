package lotto.utils

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoGeneratorTest {
    @Test
    fun `오름차순 정렬이 정상적으로 동작하는지 확인한다`() {
        val lottoGenerator = LottoGenerator(1, 6, 6)
        val lotto = lottoGenerator.getLotto()

        assertThat(lotto.getNumbers()).isEqualTo(listOf(1, 2, 3, 4, 5, 6))
    }

    @Test
    fun `범위 내의 숫자만 생성되는지 확인한다`() {
        val lottoGenerator = LottoGenerator()
        val lotto = lottoGenerator.getLotto()

        assertThat(lotto.getNumbers()).allMatch { it in 1..45 }
    }
}