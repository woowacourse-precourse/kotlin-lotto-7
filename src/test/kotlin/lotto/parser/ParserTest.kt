package lotto.parser

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ParserTest {

    private val parser = Parser()

    @Test
    fun `구입금액이 정상적으로 파싱된다`() {
        val input = "1000"
        val result = parser.parsePurchaseAmount(input)
        assertEquals(1000, result)
    }

    @Test
    fun `당첨 번호가 정상적으로 파싱된다`() {
        val input = "1,2,3,4,5,6"
        val result = parser.parseWinningNumbers(input)
        assertEquals(listOf(1, 2, 3, 4, 5, 6), result)
    }

    @Test
    fun `보너스 번호가 정상적으로 파싱된다`() {
        val input = "7"
        val result = parser.parseBonusNumber(input)
        assertEquals(7, result)
    }

    @Test
    fun `구입금액이 숫자가 아닌 경우 예외가 발생한다`() {
        val input = "천"
        assertThrows<NumberFormatException> {
            parser.parsePurchaseAmount(input)
        }
    }

    @Test
    fun `당첨 번호에서 숫자가 아닌 값이 포함된 경우 예외가 발생한다`() {
        val input = "1, 2, a, 4, 5, 6"
        assertThrows<NumberFormatException> {
            parser.parseWinningNumbers(input)
        }
    }

    @Test
    fun `보너스 번호가 숫자가 아닌 경우 예외가 발생한다`() {
        val input = "일"
        assertThrows<NumberFormatException> {
            parser.parseBonusNumber(input)
        }
    }
}