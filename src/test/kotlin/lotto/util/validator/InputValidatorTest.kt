package lotto.util.validator

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class InputValidatorTest {
    @Test
    fun `입력 값이 숫자가 아닐 때 예외 테스트`() {
        assertThrows<IllegalArgumentException> {
            require(InputValidator.isNumber("a"))
        }
    }

    @Test
    fun `입력 값이 숫자일 때 성공 테스트`() {
        assertDoesNotThrow {
            require(InputValidator.isNumber("1"))
        }
    }

    @Test
    fun `입력 값이 비어 있을 때 예외 테스트`() {
        assertThrows<IllegalArgumentException> {
            require(InputValidator.isNotEmpty(""))
        }
    }

    @Test
    fun `입력 값이 비어 있지 않을 때 성공 테스트`() {
        assertDoesNotThrow {
            require(InputValidator.isNotEmpty("11"))
        }
    }

    @Test
    fun `입력 값을 쉼표로 구분하지 않았을 때 예외 테스트`() {
        assertThrows<IllegalArgumentException> {
            require(InputValidator.isDelimiterValid("1/1/1/1/1/1", COMMA))
        }
    }

    @Test
    fun `입력 값을 쉼표로 구분 했을 때 성공 테스트`() {
        assertDoesNotThrow {
            require(InputValidator.isDelimiterValid("1,1,1,1,1,1", COMMA))
        }
    }

    @Test
    fun `로또 번호와 보너스 번호가 중복일 때 예외 테스트`() {
        assertThrows<IllegalArgumentException> {
            require(InputValidator.isBonusNumberUnique(listOf(1,2), 1))
        }
    }

    @Test
    fun `로또 번호와 보너스 번호가 중복이 아닐 때 성공 테스트`() {
        assertDoesNotThrow {
            require(InputValidator.isBonusNumberUnique(listOf(1,2), 3))
        }
    }

    companion object {
        private const val COMMA = ','
    }
}