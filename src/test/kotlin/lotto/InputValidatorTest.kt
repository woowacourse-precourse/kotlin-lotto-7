package lotto

import lotto.util.InputValidator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class InputValidatorTest {

    private val validator = InputValidator()

    @Test
    fun `구입 금액이 숫자가 아니면 예외가 발생한다`() {
        val result = validator.validatePurchasePrice("abc")
        assertThat(result).isNull()
    }

    @Test
    fun `구입 금액이 1000원 단위가 아니면 예외가 발생한다`() {
        val result = validator.validatePurchasePrice("1500")
        assertThat(result).isNull()
    }

    @Test
    fun `구입 금액이 유효한 경우 금액을 반환한다`() {
        val result = validator.validatePurchasePrice("3000")
        assertThat(result).isEqualTo(3000)
    }

    @Test
    fun `당첨 번호가 유효하지 않은 경우 예외가 발생한다`() {
        val result = validator.validateWinningNumbers("1, 2, 3, 4, 5")
        assertThat(result).isNull()
    }

    @Test
    fun `당첨 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        val result = validator.validateWinningNumbers("1, 2, 3, 4, 5, 5")
        assertThat(result).isNull()
    }

    @Test
    fun `당첨 번호가 1부터 45 범위를 벗어나면 예외가 발생한다`() {
        val result = validator.validateWinningNumbers("0, 2, 3, 4, 5, 6")
        assertThat(result).isNull()

        val result2 = validator.validateWinningNumbers("1, 2, 3, 4, 5, 46")
        assertThat(result2).isNull()
    }

    @Test
    fun `당첨 번호가 유효한 경우 숫자 리스트를 반환한다`() {
        val result = validator.validateWinningNumbers("1, 2, 3, 4, 5, 6")
        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6)
    }

    @Test
    fun `보너스 번호가 1-45 범위를 벗어나면 예외가 발생한다`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val result = validator.validateBonusNumber("0", winningNumbers)
        assertThat(result).isNull()

        val result2 = validator.validateBonusNumber("46", winningNumbers)
        assertThat(result2).isNull()
    }

    @Test
    fun `보너스 번호가 당첨 번호와 중복되면 예외가 발생한다`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val result = validator.validateBonusNumber("5", winningNumbers)
        assertThat(result).isNull()
    }

    @Test
    fun `보너스 번호가 유효한 경우 숫자를 반환한다`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val result = validator.validateBonusNumber("7", winningNumbers)
        assertThat(result).isEqualTo(7)
    }
}