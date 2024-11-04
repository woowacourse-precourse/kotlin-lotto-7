package lotto.domain.validation

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ValidateBonusWinnningNumberKtTest {
    @ParameterizedTest
    @ValueSource(ints = [1, 45])
    fun `보너스 당첨 번호가 올바른 범위 내에 있고 당첨 번호화 중복이 되지 않을 경우 아무 일도 일어나지 않음`(bonusWinningNumber: Int) {
        val winningNumbers = listOf(2, 3, 4, 5, 6, 7)

        // act, assert
        assertDoesNotThrow { validateBonusWinningNumber(bonusWinningNumber, winningNumbers) }
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 46])
    fun `보너스 당첨 번호가 올바른 범위 내에 있지 않을 경우 예외 발생`(bonusWinningNumber: Int) {
        val winningNumbers = listOf(2, 3, 4, 5, 6, 7)

        // act, assert
        assertThrows<IllegalArgumentException> { validateBonusWinningNumber(bonusWinningNumber, winningNumbers) }
    }

    @Test
    fun `보너스 당첨 번호와 당첨 번호가 중복이 될 경우 예외 발생`() {
        // arrange
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)

        // act, assert
        assertThrows<IllegalArgumentException> { validateBonusWinningNumber(1, winningNumbers) }
    }
}
