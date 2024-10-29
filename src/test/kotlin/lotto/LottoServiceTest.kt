package lotto

import lotto.domain.Money
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoServiceTest {
    private lateinit var lottoService: LottoService

    @BeforeEach
    fun setup() {
        lottoService = LottoService()
    }

    @ParameterizedTest
    @ValueSource(ints = [1_000, 2_000, 23_000, 1_030_000])
    fun `입력한 비용 만큼 로또를 발행한다`(value: Int) {
        val money = Money(value)
        lottoService.issueLottos(money)

        val lottoCount = lottoService.lottos.size
        assertEquals(lottoCount, money.amount / LOTTO_PRICE)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 100, 999, 1100, 3_321_341])
    fun `잘못된 비용이 입력되면 예외가 발생한다`(value: Int) {
        val money = Money(value)

        assertThrows<IllegalArgumentException> {
            lottoService.issueLottos(money)
        }
    }

    companion object {
        const val LOTTO_PRICE = 1_000
    }
}
