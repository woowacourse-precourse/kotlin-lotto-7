package lotto

import lotto.extention.parseToIntOrThrow
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class StringExtensionsTest {

    @ParameterizedTest
    @CsvSource(
        "1, 1",
        "90, 90",
        "12, 12",
        "5, 5"
    )
    fun `문자열이 int타입으로 반환이 되는지 테스트`(input: String, expected: Int) {
        val result = input.parseToIntOrThrow()
        assertEquals(expected, result)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1.1", "90.3", "a12", "$1"])
    fun `int 타입으로 반환이 안될 경우에 에러를 발생시키는지 테스트`(input: String) {
        assertThrows<IllegalArgumentException> { input.parseToIntOrThrow() }
    }
}