package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {

    @Test
    fun `로또 번호가 비어있는 경우 예외가 발생한다`() {
        // Given
        val numbers = emptyList<Int>()

        // When
        val exception = assertThrows<IllegalArgumentException> {
            Lotto(numbers)
        }

        // Then
        assertEquals(NUMBER_EMPTY_ERROR_MESSAGE, exception.message)
    }

    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        // Given
        val numbers = listOf(1, 2, 3, 4, 5, 6, 7)

        // When
        val exception = assertThrows<IllegalArgumentException> {
            Lotto(numbers)
        }

        // Then
        assertEquals(NUMBER_SIZE_ERROR_MESSAGE, exception.message)
    }

    @Test
    fun `로또 번호의 개수가 6개 보다 작으면 예외가 발생한다`() {
        // Given
        val numbers = listOf(1, 2, 3, 4, 5)

        // When
        val exception = assertThrows<IllegalArgumentException> {
            Lotto(numbers)
        }

        // Then
        assertEquals(NUMBER_SIZE_ERROR_MESSAGE, exception.message)
    }

    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        // Given
        val numbers = listOf(1, 2, 3, 4, 5, 5)

        // When
        val exception = assertThrows<IllegalArgumentException> {
            Lotto(numbers)
        }

        // Then
        assertEquals(NUMBER_DISTINCT_ERROR_MESSAGE, exception.message)
    }

    @Test
    fun `주어진 범위를 벗어난 로또번호가 있는 경우 예외를 발생시킨다`() {
        // Given
        val numbers = listOf(1, 2, 3, 4, 5, 60)

        // When
        val exception = assertThrows<IllegalArgumentException> {
            Lotto(numbers)
        }

        // Then
        assertEquals(NUMBER_RANGE_ERROR_MESSAGE, exception.message)
    }

    @Test
    fun `올바른 숫자 리스트가 주어진 경우 올바른 값을 반환한다`() {
        // Given
        val numbers = listOf(1, 2, 3, 4, 5, 6)

        // When
        val lotto = Lotto(numbers).getNumbers()

        // Then
        assertThat(lotto).isEqualTo(numbers)
    }

    @Test
    @DisplayName("올바른 숫자 리스트가 주어진 경우, 올바른 값을 문자열로 반환한다.")
    fun toStringTest() {
        // Given
        val numbers = listOf(1, 2, 3, 4, 5, 6)

        // When
        val lotto = Lotto(numbers).toString()

        // Then
        assertThat("[1, 2, 3, 4, 5, 6]").isEqualTo(lotto)
    }

    companion object {
        private const val START_RANGE = 1
        private const val END_RANGE = 45
        private const val NUMBER_EMPTY_ERROR_MESSAGE = "로또 번호는 비어있을 수 없습니다."
        private const val NUMBER_SIZE_ERROR_MESSAGE = "로또 번호는 6개여야 합니다."
        private const val NUMBER_DISTINCT_ERROR_MESSAGE = "로또 번호는 중복될 수 없습니다."
        private const val NUMBER_RANGE_ERROR_MESSAGE = "로또 번호는 $START_RANGE ~ $END_RANGE 중 하나여야 합니다."
    }

}
