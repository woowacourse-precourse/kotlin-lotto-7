package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class SetTest {

    private val number = mutableSetOf<Int>()

    @BeforeEach
    fun setUp() {
        number.add(1)
        number.add(1)
        number.add(2)
        number.add(3)
    }

    @Test
    fun `집합에 특정 값이 있는지 확인한다`() {
        assertThat(number).contains(1)
        assertThat(number).contains(2)
        assertThat(number).contains(3)
    }

    @ParameterizedTest
    @CsvSource(
        "1, true",
        "2, true",
        "3, true",
        "4, false",
        "5, false"
    )
    fun `집합에 특정 값이 있는지 참 거짓을 확인한다`(element: Int, expected: Boolean) {
        assertThat(number.contains(element)).isEqualTo(expected)
    }
}
