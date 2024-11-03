package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoServiceTest {
    @Test
    fun `금액에 맞는 로또가 발행된다`(){
        val money = 10000
        assertThat(LottoService().calculateQuantity(money)).isEqualTo(10)
    }
}