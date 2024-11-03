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
}