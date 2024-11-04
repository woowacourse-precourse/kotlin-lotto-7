package lotto.util

import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ValidatorTest {
    private lateinit var validator: Validator

    @BeforeEach
    fun setUp() {
        validator = Validator()
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "0", "999", "100001"])
    fun `천원-십만원 사이의 금액이 아닌 경우 예외가 발생한다`(testPrice: Int) {
        assertThrows<IllegalArgumentException> {
            validator.validatePriceRange(testPrice)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1001", "99999"])
    fun `구입 금액은 천원으로 나누어지지 않는 경우 예외가 발생한다`(testPrice: Int) {
        assertThrows<IllegalArgumentException> {
            validator.validatePriceUnit(testPrice)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "0", "46"])
    fun `로또 번호는 1-45 사이의 숫자가 아닌 경우 예외가 발생한다`(testNumber: Int) {
        assertThrows<IllegalArgumentException> {
            validator.validateLottoNumberRange(testNumber)
        }
    }
}