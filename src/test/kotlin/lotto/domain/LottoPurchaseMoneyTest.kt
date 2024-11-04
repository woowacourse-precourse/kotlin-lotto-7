package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoPurchaseMoneyTest {

    @ParameterizedTest
    @ValueSource(ints = [1_000, 2_000, 10_000, 23_000])
    fun `정상적인 로또 금액을 입력한다`(input: Int) {
        val result = LottoPurchaseMoney(input)

        assertEquals(result.amount, input)
    }

    @ParameterizedTest
    @ValueSource(ints = [900, 1_100, 2_030, 10_600, 3_231_400])
    fun `로또 금액으로 나누어 떨어지지 않는 금액을 입력하면 예외가 발생`(input: Int) {
        assertThrows<IllegalArgumentException> {
            LottoPurchaseMoney(input)
        }
    }
}
