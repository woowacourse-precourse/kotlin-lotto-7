package lotto.data

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {

    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto("1,2,3,4,5,5")
        }.also { exception ->
            println(exception)
        }
    }

    @Test
    fun `로또 번호에 숫자가 아닌 값이 있으면 예외가 발생한다`() {
        assertThrows<NumberFormatException> {
            Lotto("1,2,3,4,5,a")
        }.also { exception ->
            println(exception)
        }
    }

    @Test
    fun `로또 번호가 1부터 45 사이의 숫자가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto("0,2,3,4,5,6")
        }
        assertThrows<IllegalArgumentException> {
            Lotto("1,2,3,4,5,46")
        }
    }

    @Test
    fun `정상적인 로또 번호로 객체가 생성된다`() {
        val lotto = Lotto("1,2,3,4,5,6")
        assertEquals(listOf(1, 2, 3, 4, 5, 6), lotto.getWinningNumber())
    }

}
