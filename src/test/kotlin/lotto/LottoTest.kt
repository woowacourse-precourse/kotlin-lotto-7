package lotto

import lotto.model.Lotto
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
    fun `로또 번호의 개수가 6개 미만이면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3))
        }
    }

    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `로또 번호가 1부터 45 사이에 있어야 한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(0, 2, 3, 4, 5, 6))
        }
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 46))
        }
    }

    @Test
    fun `유효한 로또 번호가 주어지면 로또 객체가 생성된다`() {
        val validLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertEquals(listOf(1, 2, 3, 4, 5, 6), validLotto.getNumbers())
    }

    @Test
    fun `로또 번호와 당첨 번호의 일치 개수를 계산한다`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val matchCount = lotto.countMatchingNumbers(listOf(1, 2, 7, 8, 9, 10))
        assertEquals(2, matchCount)
    }

    @Test
    fun `로또 번호와 보너스 번호의 일치 여부를 확인한다`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val isBonusMatchTrue = lotto.matchBonusNumber(6)
        val isBonusMatchFalse = lotto.matchBonusNumber(7)

        assertEquals(true, isBonusMatchTrue)
        assertEquals(false, isBonusMatchFalse)
    }


}
