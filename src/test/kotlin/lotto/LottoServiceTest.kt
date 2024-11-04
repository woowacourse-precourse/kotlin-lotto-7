package lotto

import lotto.service.LottoService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoServiceTest {
    private val service = LottoService()

    @ParameterizedTest
    @ValueSource(ints = [1000])
    @DisplayName("하나 구매한 로또 번호 개수가 6개인지 확인")
    fun `로또 구매 개수 확인 테스트`(money: Int) {
        assertThat(service.purchaseLottos(money).first().getNumbers().size).isEqualTo(6)
    }
}