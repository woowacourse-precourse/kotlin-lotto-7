package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class UtilsTest {

    @Test
    fun `양수 문자열을 입력하면 문제 없이 변환된다`() {
        val input = 1234
        val result = convertInt(input.toString())

        assertEquals(result, input)
    }

    @Test
    fun `텍스트 문자열을 입력하면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            convertInt("우테코")
        }
    }

    @Test
    fun `,로 구분된 숫자 문자열을 List로 변환한다`() {
        val input = listOf(1, 2, 3, 4)
        val result = convertListInt(input.joinToString(","))

        assertEquals(input.size, result.size)
        assertThat(result).containsAll(input)
    }

    @ParameterizedTest
    @CsvSource(value = ["1:1", "1030:1,030", "1000000:1,000,000"], delimiter = ':')
    fun `숫자를 원 단위의 문자열로 출력한다`(input: Int, result: String) {
        assertTrue(formatWon(input).contains(result))
    }
}
