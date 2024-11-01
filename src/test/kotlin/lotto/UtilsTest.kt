package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

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
        input.forEach { assertTrue(result.contains(it)) }
    }
}
