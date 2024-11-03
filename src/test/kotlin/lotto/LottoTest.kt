package lotto

import org.junit.jupiter.api.Assertions
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
    fun `로또 번호의 개수가 6개보다 적으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `로또 번호가 45보다 크면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 46))
        }
    }

    @Test
    fun `로또 번호가 1보다 작으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(0, 2, 3, 4, 5, 6))
        }
    }

    @Test
    fun `matchCount 메서드 확인`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        Assertions.assertEquals(lotto.matchCount(listOf(1, 2, 3, 4, 5, 6)), 6)
        Assertions.assertEquals(lotto.matchCount(listOf(1, 2, 3, 10, 11, 12)), 3)
    }

    @Test
    fun `isMatch 메서드 확인`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        Assertions.assertTrue(lotto.isMatch(1))
        Assertions.assertFalse(lotto.isMatch(7))
    }
}
