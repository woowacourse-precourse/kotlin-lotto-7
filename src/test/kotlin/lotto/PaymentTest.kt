package lotto

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PaymentTest {

    @ParameterizedTest
    @ValueSource(strings = ["asdf", "5000qwer"])
    fun `숫자가 아닌 입력을 받았을 때`(payment: String) {
        assertThrows<IllegalArgumentException> {
            Payment(payment)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "-5000"])
    fun `0이하의 숫자일 때`(payment: String) {
        assertThrows<IllegalArgumentException> {
            Payment(payment)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1500", "112233"])
    fun `1000 단위로 나누어 떨어지지 않을 때`(payment: String) {
        assertThrows<IllegalArgumentException> {
            Payment(payment)
        }
    }
}