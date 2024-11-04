package lotto

import lotto.domain.LottoNumberValidator
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberValidatorTest {
    @Test
    fun `로또 번호의 범위가 1~45 사이가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            LottoNumberValidator.validate(0)
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 10, 45])
    fun `로또 번호 범위 확인`(input: Int) {
        assertDoesNotThrow { LottoNumberValidator.validate(input) }
    }
}