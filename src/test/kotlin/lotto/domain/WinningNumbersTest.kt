package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class WinningNumbersTest {

    @Test
    fun `당첨번호에 값이 빈 값이 들어오면 예외를 발생시킨다`() {
        // Given
        val inputNumber = ""

        // When
        val exception = assertThrows<IllegalArgumentException> {
            WinningNumbers(inputNumber)
        }

        // Then
        assertThat("당첨 번호는 비어있을 수 없습니다.").isEqualTo(exception.message)
    }

    @Test
    fun `당첨번호 값이 숫자가 아닌 경우 예외를 발생시킨다`() {
        // Given
        val inputNumber = "1,2,3,q,5"

        // When
        val exception = assertThrows<IllegalArgumentException> {
            WinningNumbers(inputNumber)
        }

        // Then
        assertThat("당첨 번호는 숫자를 입력해야 합니다.").isEqualTo(exception.message)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4,5,6,7", "1,2,3,4,5"])
    fun `당첨 번호의 개수가 6개가 아닌경우 예외가 발생한다`(inputNumber: String) {
        // When
        val exception = assertThrows<IllegalArgumentException> {
            WinningNumbers(inputNumber)
        }

        // Then
        assertThat("당첨 번호는 6개여야 합니다.").isEqualTo(exception.message)
    }

    @Test
    fun `당첨 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        // Given
        val inputNumber = "1,2,3,4,5,5"

        // When
        val exception = assertThrows<IllegalArgumentException> {
            WinningNumbers(inputNumber)
        }

        // Then
        assertThat("당첨 번호는 중복될 수 없습니다.").isEqualTo(exception.message)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4,5,-2", "1,2,3,4,5,50"])
    fun `잘못된 범위의 당첨 번호가 있는 경우 예외를 발생시킨다`(inputNumber: String) {
        // When
        val exception = assertThrows<IllegalArgumentException> {
            WinningNumbers(inputNumber)
        }

        // Then
        assertThat("당첨 번호는 1 ~ 45 중 하나여야 합니다.").isEqualTo(exception.message)
    }

    @Test
    fun `올바른 당첨 번호가 주어진 경우 올바른 값을 반환한다`() {
        // Given
        val inputNumber = "1,2,3,4,5,6"
        val result = listOf(1, 2, 3, 4, 5, 6)

        // When
        val winningNumbers = WinningNumbers(inputNumber).winningNumbers

        // Then
        assertThat(result).isEqualTo(winningNumbers)
    }

}
