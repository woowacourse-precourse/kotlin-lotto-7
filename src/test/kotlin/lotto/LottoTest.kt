package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    // TODO: 테스트가 통과하도록 프로덕션 코드 구현
    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
    @Test
    fun `로또 번호가 6개일 때 성공적으로 생성된다`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(numbers)
        assertEquals("[1, 2, 3, 4, 5, 6]", lotto.toString())
    }

    @Test
    fun `당첨 번호와 일치하는 번호의 개수를 정확히 센다`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(numbers)
        val winningNumbers = listOf(1, 2, 3, 7, 8, 9)
        assertEquals(3, lotto.countMatchingNumbers(winningNumbers))
    }

    @Test
    fun `보너스 번호가 로또 번호와 일치하면 true를 반환한다`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(numbers)
        val bonusNumber = 6
        assertTrue(lotto.isBonusMatched(bonusNumber))
    }

    @Test
    fun `보너스 번호가 로또 번호와 일치하지 않으면 false를 반환한다`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(numbers)
        val bonusNumber = 7
        assertFalse(lotto.isBonusMatched(bonusNumber))
    }


}
