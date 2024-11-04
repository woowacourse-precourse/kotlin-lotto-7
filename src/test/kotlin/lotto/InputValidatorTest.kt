package lotto

import lotto.validator.InputValidator
import lotto.validator.NumberValidator
import net.bytebuddy.pool.TypePool.Resolution.Illegal
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalStateException

class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = ["1000", "40000"])
    fun `구매 금액이 1000원 단위의 올바른 금액을 입력할 경우 허용한다`(input: String) {
        val inputValidator = InputValidator()
        assertDoesNotThrow {
            inputValidator.validatePriceInput(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "1200", "334211", "540"])
    fun `구매 금액이 1000원 단위가 아니면 예외가 발생한다`(input: String) {
        val inputValidator = InputValidator()
        assertThrows<IllegalArgumentException> {
            inputValidator.validatePriceInput(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1000", "-3400", "-500000", "-2020"])
    fun `구매 금액이 음수면 예외가 발생한다`(input: String) {
        val inputValidator = InputValidator()
        assertThrows<IllegalArgumentException> {
            inputValidator.validatePriceInput(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1.1", "1.1001", "0.32413", "2.239392"])
    fun `구매 금액이 소수면 예외가 발생한다`(input: String) {
        val inputValidator = InputValidator()
        assertThrows<IllegalArgumentException> {
            inputValidator.validatePriceInput(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "00", "000", "0000"])
    fun `구매 금액이 0이면 예외가 발생한다`(input: String) {
        val inputValidator = InputValidator()
        assertThrows<IllegalArgumentException> {
            inputValidator.validatePriceInput(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["7", "32", "44", "26", "11"])
    fun `보너스 번호가 1~45 범위 내에 중복되지 않은 입력을 할 경우 허용한다`(input: String) {
        val inputValidator = InputValidator()
        assertDoesNotThrow {
            inputValidator.validateBonusNumberInput(listOf(1, 2, 3, 4, 5, 6), bonusNumber = input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "2", "3", "4", "5", "6"])
    fun `보너스 번호와 당첨 번호가 중복될 경우 예외가 발생한다`(input: String) {
        val inputValidator = InputValidator()
        assertThrows<IllegalArgumentException> {
            inputValidator.validateBonusNumberInput(listOf(1, 2, 3, 4, 5, 6), bonusNumber = input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1000", "54", "3242341", "49"])
    fun `보너스 번호가 1~45 범위를 벗어날 경우 예외가 발생한다`(input: String) {
        val inputValidator = InputValidator()
        assertThrows<IllegalArgumentException> {
            inputValidator.validateBonusNumberInput(listOf(1, 2, 3, 4, 5, 6), bonusNumber = input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = [""])
    fun `입력이 비어있으면 예외가 발생한다`(input: String) {
        val inputValidator = InputValidator()
        assertThrows<IllegalStateException> {
            inputValidator.validatePriceInput(input)
            inputValidator.validateWinningNumbers(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1","30321.3324","fadfadf","abc32114","-1.1","234.122"])
    fun `입력이 양의 정수가 아닌 경우 예외가 발생한다`(input: String) {
        assertThrows<IllegalArgumentException> {
            NumberValidator.validateInteger(input)
        }
    }
}