package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class StringTest {

    @Test
    fun `split 메서드로 주어진 값을 구분한다`() {
        // Given
        val input = "1,2"

        // When
        val result = input.split(",")

        // Then
        assertThat(result).contains("1", "2")
        assertThat(result).containsExactly("1", "2")
    }

    @Test
    fun `구분기호가 없는 경우 그대로를 반환한다`() {
        // Given
        val input = "1"

        // When
        val result = input.split(",")

        // Then
        assertThat(result).contains("1")
        assertThat(result).containsExactly("1")
    }

    @Test
    fun `subString로 특정 값을 구한다`() {
        // Given
        val input = "(1,2)"

        // When
        val result = input.substring(1, 4)

        // Then
        assertThat(result).isEqualTo("1,2")
    }

    @Test
    fun `특정 위치의 문자를 찾는다`() {
        // Given
        val input = "abc"

        // When
        val result = input[0]

        // Then
        assertThat(result).isEqualTo('a')
    }

    @Test
    @DisplayName("문자열의 길이보다 큰 위치의 문자를 찾는 경우 예외가 발생한다")
    fun validInputRange() {
        // Given
        val input = "abc"

        // When & Then
        assertThrows<StringIndexOutOfBoundsException>("String index out of range: 5") {
            input[5]
        }
    }
}
