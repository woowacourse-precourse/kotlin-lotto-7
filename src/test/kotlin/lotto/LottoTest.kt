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
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `1보다 작고 45보다 큰 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 55, 5))
        }
    }

    @Test
    fun `로또 번호의 개수가 6개보다 적으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `보너스 번호가 1보다 작고 45보다 크면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            BonusNumber(46, listOf(1, 2, 3, 4, 5, 6))
        }
    }

    @Test
    fun `보너스 번호가 당첨번호에 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            BonusNumber(3, listOf(1, 2, 3, 4, 5, 6))
        }
    }
}
