package lotto.util.validator

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class LottoValidatorTest {
    @Test
    fun `숫자 리스트 사이즈가 6개 미만일 때 예외 테스트`() {
        assertThrows<IllegalArgumentException> {
            require(LottoValidator.isNumbersLengthSix(LIST_OF_FIVE_LENGTH))
        }
    }

    @Test
    fun `숫자 리스트 사이즈가 6개일 때 성공 테스트`() {
        assertDoesNotThrow {
            require(LottoValidator.isNumbersLengthSix(LIST_OF_SIX_LENGTH))
        }
    }

    @Test
    fun `숫자 리스트 사이즈가 6개 초과일 때 예외 테스트`() {
        assertThrows<IllegalArgumentException> {
            require(LottoValidator.isNumbersLengthSix(LIST_OF_SEVEN_LENGTH))
        }
    }

    @Test
    fun `숫자 리스트에 중복 값이 있을 때 예외 테스트`() {
        assertThrows<IllegalArgumentException> {
            require(LottoValidator.isNumbersUnique(NOT_UNIQUE_NUMBERS))
        }
    }

    @Test
    fun `숫자 리스트에 중복 값이 없을 때 성공 테스트`() {
        assertDoesNotThrow {
            require(LottoValidator.isNumbersUnique(UNIQUE_NUMBERS))
        }
    }

    @Test
    fun `로또 최대 번호를 초과할 때 예외 테스트`() {
        assertThrows<IllegalArgumentException> {
            require(LottoValidator.isMaximumNumberExceeded(LIST_CONTAIN_MAX_NUMBER))
        }
    }

    @Test
    fun `로또 최대 번호를 초과하지 않았을 때 성공 테스트`() {
        assertDoesNotThrow {
            require(LottoValidator.isMaximumNumberExceeded(LIST_NOT_CONTAIN_MAX_NUMBER))
        }
    }

    companion object {
        private val LIST_OF_FIVE_LENGTH = listOf(1,2,3,4,5)
        private val LIST_OF_SIX_LENGTH = listOf(1,2,3,4,5,6)
        private val LIST_OF_SEVEN_LENGTH = listOf(1,2,3,4,5,6,7)
        private val NOT_UNIQUE_NUMBERS = listOf(1,1)
        private val UNIQUE_NUMBERS = listOf(1,2)
        private val LIST_CONTAIN_MAX_NUMBER = listOf(1,2,3,46)
        private val LIST_NOT_CONTAIN_MAX_NUMBER = listOf(1,2,3,5)
    }
}