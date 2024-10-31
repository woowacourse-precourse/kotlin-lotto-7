package lotto.domain

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows

class InputNumbersTest {

    @Test
    fun `당첨 번호의 개수가 6개가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            InputNumbers("1,2,3,4,5,6,7", "8")
        }
    }

    @Test
    fun `당첨 번호가 중복되면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            InputNumbers("1,2,3,4,6,6", "8")
        }
    }

    @Test
    fun `당첨 번호의 범위가 1-45가 아니라면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            InputNumbers("1,2,3,4,6,46", "8")
        }
    }

    @Test
    fun `보너스 번호가 숫자가 아닐시 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            InputNumbers("1,2,3,4,6,7", "a")
        }
    }

    @Test
    fun `보너스 번호의 범위가 1-45가 아니라면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            InputNumbers("1,2,3,4,6,45", "46l")
        }
    }

    @Test
    fun `당첨번호 숫자리스트 변환 테스트`() {
        val result = InputNumbers("1,2,3,4,5,6", "7").winningNumbers
        val expected = listOf(1, 2, 3, 4, 5, 6)

        assertEquals(expected, result)
    }

    @Test
    fun `보너스 번호 숫자 변환 테스트`() {
        val result = InputNumbers("1,2,3,4,5,6", "7").bonusNumber
        val expected = 7

        assertEquals(expected, result)
    }
}