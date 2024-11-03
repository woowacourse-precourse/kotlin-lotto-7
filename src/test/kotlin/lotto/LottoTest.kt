package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 아닐 경우 예외가 발생한다`() {
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
    fun `로또 번호에 보너스 번호가 포함되는지 확인할 수 있다`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 5
        assertTrue(lotto.containsBonusNumber(bonusNumber))
    }

    @Test
    fun `로또 객체는 로또 번호 6자를 출력해야 한다`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertEquals("[1, 2, 3, 4, 5, 6]", lotto.toString())
    }

    @Test
    fun `로또 객체는 당첨 번호와 일치하는 수의 개수를 반환해야 한다`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertEquals(3, lotto.countMatchingNumbers(listOf(1, 3, 5, 7, 9, 11)))
    }
}
