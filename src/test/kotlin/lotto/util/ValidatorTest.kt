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

    @Nested
    @DisplayName("구입 금액 테스트")
    inner class PriceTest {
        @ParameterizedTest
        @ValueSource(strings = ["-1", "0", "999", "1000.0", "100001"])
        fun `천원-십만원 사이의 정수가 아닌 경우 예외가 발생한다`(testInput: String) {
            assertThrows<IllegalArgumentException> {
                validator.getValidPrice(testInput)
            }
        }

        @ParameterizedTest
        @ValueSource(strings = ["1001", "99999"])
        fun `구입 금액은 천원으로 나누어지지 않는 경우 예외가 발생한다`(testInput: String) {
            assertThrows<IllegalArgumentException> {
                validator.getValidPrice(testInput)
            }
        }
    }

    @Nested
    @DisplayName("당첨 숫자 테스트")
    inner class WinningNumbersTest {
        @Test
        fun `콤마로 숫자를 구분한다`() {
            val testInput = "1,2,3,4,5,6"
            val expected = listOf(1, 2, 3, 4, 5, 6)
            val actual = validator.getValidWinningNumbers(testInput)
            assertEquals(expected, actual)
        }

        @ParameterizedTest
        @ValueSource(strings = ["0,1,2,3,4,5", "1,2,3,4,5,46", "1.0,2,3,4,5,6"])
        fun `1-45 사이의 정수가 아닌 경우 예외가 발생한다`(testInput: String) {
            assertThrows<IllegalArgumentException> {
                validator.getValidPrice(testInput)
            }
        }

        @ParameterizedTest
        @ValueSource(strings = ["1,2,3,4,5", "1,2,3,4,5,6,7"])
        fun `숫자가 6개가 아닌 경우 예외가 발생한다`(testInput: String) {
            assertThrows<IllegalArgumentException> {
                validator.getValidPrice(testInput)
            }
        }

        @ParameterizedTest
        @ValueSource(strings = ["1,1,2,3,4,5", "45,45,45,45,45,45"])
        fun `중복된 값이 있을 경우 예외가 발생한다`(testInput: String) {
            assertThrows<IllegalArgumentException> {
                validator.getValidPrice(testInput)
            }
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "0", "1.0", "46"])
    fun `보너스 번호는 1-45 사이의 졍수가 아닌 경우 예외가 발생한다`(testInput: String) {
        assertThrows<IllegalArgumentException> {
            validator.getValidBonusNumber(testInput)
        }
    }
}