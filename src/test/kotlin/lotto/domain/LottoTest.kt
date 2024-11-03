package lotto.domain

import lotto.util.Constants
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {

    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        val exception = assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
        assertEquals(Constants.ERROR_INVALID_LOTTO_NUMBERS_SIZE, exception.message)
    }

    @Test
    fun `로또 번호의 개수가 6개 미만이면 예외가 발생한다`() {
        val exception = assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5))
        }
        assertEquals(Constants.ERROR_INVALID_LOTTO_NUMBERS_SIZE, exception.message)
    }

    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        val exception = assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
        assertEquals(Constants.ERROR_DUPLICATE_NUMBER, exception.message)
    }

    @Test
    fun `로또 번호의 숫자가 1부터 45 사이가 아니면 예외가 발생한다`() {
        val exception = assertThrows<IllegalArgumentException> {
            Lotto(listOf(0, 2, 3, 4, 5, 6))
        }
        assertEquals(Constants.ERROR_NUMBER_OUT_OF_RANGE, exception.message)
    }

    @Test
    fun `로또 번호가 1부터 45 사이의 숫자 6개로 이루어지면 정상적으로 생성된다`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertEquals(listOf(1, 2, 3, 4, 5, 6), lotto.getNumbers())
    }

    @Test
    fun `로또 번호 자동 생성시 6개의 번호가 생성된다`() {
        val lotto = Lotto()
        assertEquals(6, lotto.getNumbers().size)
    }

    @Test
    fun `로또 번호 자동 생성시 번호는 1부터 45 사이의 숫자이다`() {
        val lotto = Lotto()
        assertTrue(lotto.getNumbers().all { it in Constants.LOTTO_NUMBER_MIN..Constants.LOTTO_NUMBER_MAX })
    }


}
