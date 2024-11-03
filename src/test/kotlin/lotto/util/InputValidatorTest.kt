package lotto.util

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class InputValidatorTest {
    private val inputValidator = InputValidator()
    @Test
    fun `구입 금액이 숫자가 아닌 경우 예외가 발생한다`() {
        val purchaseAmount = "abc"
        assertThatThrownBy { inputValidator.validatePurchaseAmount(purchaseAmount) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(ErrorMessages.INVALID_PURCHASE_AMOUNT_FORMAT)
    }

    @Test
    fun `구입 금액이 빈 문자열인 경우 예외가 발생한다`() {
        val purchaseAmount = ""
        assertThatThrownBy { inputValidator.validatePurchaseAmount(purchaseAmount) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(ErrorMessages.INVALID_PURCHASE_AMOUNT_FORMAT)
    }

    @Test
    fun `구입 금액이 공백인 경우 예외가 발생한다`() {
        val purchaseAmount = " "
        assertThatThrownBy { inputValidator.validatePurchaseAmount(purchaseAmount) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(ErrorMessages.INVALID_PURCHASE_AMOUNT_FORMAT)
    }

    @Test
    fun `구입 금액이 소수인 경우 예외가 발생한다`() {
        val purchaseAmount = "1000.1"
        assertThatThrownBy { inputValidator.validatePurchaseAmount(purchaseAmount) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(ErrorMessages.INVALID_PURCHASE_AMOUNT_FORMAT)
    }

    @Test
    fun `구입 금액이 1000원 미만인 경우 예외가 발생한다`() {
        val purchaseAmount = "999"
        assertThatThrownBy { inputValidator.validatePurchaseAmount(purchaseAmount) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(ErrorMessages.INVALID_PURCHASE_AMOUNT_UNIT)
    }

    @Test
    fun `구입 금액이 1000원으로 나누어 떨어지지 않는 경우 예외가 발생한다`() {
        val purchaseAmount = "3001"
        assertThatThrownBy { inputValidator.validatePurchaseAmount(purchaseAmount) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(ErrorMessages.INVALID_PURCHASE_AMOUNT_UNIT)
    }

    @Test
    fun `구입 금액이 Int 범위를 초과하는 경우 예외가 발생한다`() {
        val purchaseAmount = "2147483648"
        assertThatThrownBy { inputValidator.validatePurchaseAmount(purchaseAmount) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(ErrorMessages.INVALID_PURCHASE_AMOUNT_FORMAT)
    }

    @Test
    fun `구입 금액에 공백이 포함되는 경우 정상 작동한다`() {
        val purchaseAmountInput = " 3000  ".trim()
        inputValidator.validatePurchaseAmount(purchaseAmountInput)
        val purchaseAmount = purchaseAmountInput.toInt()
        assertThat(purchaseAmount).isEqualTo(3000)
    }

    @Test
    fun `당첨 번호가 숫자가 아닌 경우 예외가 발생한다`() {
        val winningNumbersInput = "a,b,c,d,e,f"
        val parsedWinningNumbers = winningNumbersInput.split(",").map { it.trim().toIntOrNull() }
        assertThatThrownBy { inputValidator.validateWinningNumbers(parsedWinningNumbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(ErrorMessages.INVALID_WINNING_NUMBERS_FORMAT)
    }

    @Test
    fun `당첨 번호가 소수인 경우 예외가 발생한다`() {
        val winningNumbersInput = "1.1,2.2,3,3.4.4,5.5,6.6"
        val parsedWinningNumbers = winningNumbersInput.split(",").map { it.trim().toIntOrNull() }
        assertThatThrownBy { inputValidator.validateWinningNumbers(parsedWinningNumbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(ErrorMessages.INVALID_WINNING_NUMBERS_FORMAT)
    }

    @Test
    fun `당첨 번호가 쉼표로 나눠질 수 없는 경우 예외가 발생한다`() {
        val winningNumbersInput = "1:2:3:4:5:6"
        val parsedWinningNumbers = winningNumbersInput.split(",").map { it.trim().toIntOrNull() }
        assertThatThrownBy { inputValidator.validateWinningNumbers(parsedWinningNumbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(ErrorMessages.INVALID_WINNING_NUMBERS_FORMAT)
    }

    @Test
    fun `당첨 번호가 6개의 숫자가 아닌 경우 예외가 발생한다`() {
        val winningNumbersInput = "1,2,3,4,5"
        val parsedWinningNumbers = winningNumbersInput.split(",").map { it.trim().toIntOrNull() }
        assertThatThrownBy { inputValidator.validateWinningNumbers(parsedWinningNumbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(ErrorMessages.INVALID_WINNING_NUMBERS_SIZE)
    }

    @Test
    fun `당첨 번호가 0 이하인 경우 예외가 발생한다`() {
        val winningNumbersInput = "0,1,2,3,4,5"
        val parsedWinningNumbers = winningNumbersInput.split(",").map { it.trim().toIntOrNull() }
        assertThatThrownBy { inputValidator.validateWinningNumbers(parsedWinningNumbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(ErrorMessages.INVALID_WINNING_NUMBERS_RANGE)
    }

    @Test
    fun `당첨 번호가 46 이상인 경우 예외가 발생한다`() {
        val winningNumbersInput = "1,2,3,4,5,46"
        val parsedWinningNumbers = winningNumbersInput.split(",").map { it.trim().toIntOrNull() }
        assertThatThrownBy { inputValidator.validateWinningNumbers(parsedWinningNumbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(ErrorMessages.INVALID_WINNING_NUMBERS_RANGE)
    }

    @Test
    fun `당첨 번호끼리 중복되는 경우 예외가 발생한다`() {
        val winningNumbersInput = "1,1,2,3,4,5"
        val parsedWinningNumbers = winningNumbersInput.split(",").map { it.trim().toIntOrNull() }
        assertThatThrownBy { inputValidator.validateWinningNumbers(parsedWinningNumbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(ErrorMessages.DUPLICATE_WINNING_NUMBERS)
    }

    @Test
    fun `당첨 번호에 공백이 포함되는 경우 정상 작동한다`() {
        val winningNumbersInput = "1,2,   3  ,4, 5 , 6"
        val parsedWinningNumbers = winningNumbersInput.split(",").map { it.trim().toIntOrNull() }
        inputValidator.validateWinningNumbers(parsedWinningNumbers)
        assertThat(parsedWinningNumbers).isEqualTo(listOf(1,2,3,4,5,6))
    }

    @Test
    fun `보너스 번호가 숫자가 아닌 경우 예외가 발생한다`() {
        val bonusNumber = "abc"
        assertThatThrownBy { inputValidator.validateBonusNumber(bonusNumber, listOf(1,2,3,4,5,6)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(ErrorMessages.INVALID_BONUS_NUMBER_FORMAT)
    }

    @Test
    fun `보너스 번호가 빈 문자열인 경우 예외가 발생한다`() {
        val bonusNumber = ""
        assertThatThrownBy { inputValidator.validateBonusNumber(bonusNumber, listOf(1,2,3,4,5,6)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(ErrorMessages.INVALID_BONUS_NUMBER_FORMAT)
    }

    @Test
    fun `보너스 번호가 공백인 경우 예외가 발생한다`() {
        val bonusNumber = " "
        assertThatThrownBy { inputValidator.validateBonusNumber(bonusNumber, listOf(1,2,3,4,5,6)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(ErrorMessages.INVALID_BONUS_NUMBER_FORMAT)
    }

    @Test
    fun `보너스 번호가 소수인 경우 예외가 발생한다`() {
        val bonusNumber = "1.1"
        assertThatThrownBy { inputValidator.validateBonusNumber(bonusNumber, listOf(1,2,3,4,5,6)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(ErrorMessages.INVALID_BONUS_NUMBER_FORMAT)
    }

    @Test
    fun `보너스 번호가 1 ~ 45 범위 밖에 있는 경우 예외가 발생한다`() {
        val bonusNumber = "46"
        assertThatThrownBy { inputValidator.validateBonusNumber(bonusNumber, listOf(1,2,3,4,5,6)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(ErrorMessages.INVALID_BONUS_NUMBER_RANGE)
    }

    @Test
    fun `보너스 번호가 당첨 번호에 포함된 경우 예외가 발생한다`() {
        val bonusNumber = "1"
        assertThatThrownBy { inputValidator.validateBonusNumber(bonusNumber, listOf(1,2,3,4,5,6)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(ErrorMessages.BONUS_NUMBER_ALREADY_IN_WINNING_NUMBERS)
    }

    @Test
    fun `보너스 번호에 공백이 포함되는 경우 정상 작동한다`() {
        val bonusNumberInput = " 1  ".trim()
        inputValidator.validateBonusNumber(bonusNumberInput, listOf(2,3,4,5,6,7))
        val bonusNumber = bonusNumberInput.toInt()
        assertThat(bonusNumber).isEqualTo(1)
    }

}