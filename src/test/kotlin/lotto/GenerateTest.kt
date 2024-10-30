package lotto

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import lotto.model.LottoGenerator
import org.junit.jupiter.api.assertThrows

class GenerateTest {
    private val lottoGenerator = LottoGenerator()

    @Test
    fun `구매 갯수만큼 로또 생성되는지 확인`() {
        assertThat(lottoGenerator.purchaseLotto(13414)).hasSize(13414)
    }
}
