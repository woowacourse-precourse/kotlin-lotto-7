package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {
    private val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
    private val inputNumbers = InputNumbers("1,2,3,8,9,10", "7")

    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `로또 번호의 범위가 1-45가 아닐 때 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 46))
        }
    }

    @Test
    fun `당첨 개수 테스트`() {
        val result = lotto.winningCount(inputNumbers)
        val expected = 3

        assertEquals(expected, result)
    }

    @Test
    fun `보너스 번호 당첨 테스트`() {
        val result = lotto.isBonus(inputNumbers)
        val expected = false

        assertEquals(expected, result)
    }
}
