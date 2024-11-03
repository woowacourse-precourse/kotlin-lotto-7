package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
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
        assertEquals("[ERROR] 로또 번호는 비어있을 수 없습니다.", exception.message)
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
        assertEquals("[ERROR] 로또 번호는 6개여야 합니다.", exception.message)
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
        assertEquals("[ERROR] 로또 번호는 6개여야 합니다.", exception.message)
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
        assertEquals("[ERROR] 로또 번호는 중복될 수 없습니다.", exception.message)
    }

    @Test
    fun `올바른 숫자 리스트가 주어진 경우 올바른 값을 반환한다`() {
        // Given
        val numbers = listOf(1, 2, 3, 4, 5, 6)

        // When
        val lotto = Lotto(numbers).getLotto()

        // Then
        assertThat(lotto).isEqualTo(numbers)
    }

}
