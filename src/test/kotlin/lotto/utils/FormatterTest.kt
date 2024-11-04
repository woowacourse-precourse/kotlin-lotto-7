package lotto.utils

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FormatterTest {
    @Test
    fun `숫자 출력 형식을 확인한다`() {
        val number = 1_000_000L
        val formatted = Formatter.addCommas(number)

        assertThat(formatted).isEqualTo("1,000,000")
    }

    @Test
    fun `소수 출력 형식을 확인한다`() {
        val number = 25_000_000.00
        val formatted = Formatter.addCommasToDecimal(number)

        assertThat(formatted).isEqualTo("25,000,000.0")
    }
}