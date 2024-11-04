package lotto

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
    fun `로또 번호에 숫자가 아닌 다른값이 있으면 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            validLottoNum("1,2,3,4,오,6")
        }
    }

    @Test
    fun `로또 번호가 6개가 아니면 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            validLottoNum("1,2,3,4,5")
        }
    }

    @Test
    fun `로또 번호가 1에서 45 사이에 있지 않다 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(0, 2, 3, 4, 5, 6))
        }
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 46))
        }
    }


    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

}
