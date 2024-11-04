package lotto

import lotto.model.Lotto
import lotto.model.LottoPrize
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class LottoTest {

    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows(IllegalArgumentException::class.java) {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows(IllegalArgumentException::class.java) {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `로또 번호가 1부터 45 범위를 벗어나면 예외가 발생한다`() {
        assertThrows(IllegalArgumentException::class.java) {
            Lotto(listOf(0, 2, 3, 4, 5, 6))
        }
        assertThrows(IllegalArgumentException::class.java) {
            Lotto(listOf(46, 2, 3, 4, 5, 6))
        }
    }

    @Test
    fun `로또 번호 생성 후 번호가 6개이고 정렬되어 반환된다`() {
        val lotto = Lotto(listOf(45, 23, 11, 3, 8, 42))
        val expected = listOf(3, 8, 11, 23, 42, 45)
        assertEquals(expected, lotto.getNumbers())
    }

    // 추가 테스트 예시: 당첨 검증 관련 테스트
    @Test
    fun `로또 당첨 검증 - 3개 일치`() {
        val userLotto = Lotto(listOf(1, 2, 3, 7, 8, 9))
        val winningNumbers = listOf(1, 2, 3, 10, 11, 12)
        val prize = LottoPrize.findByMatchCount(3, false)
        assertEquals(LottoPrize.FIFTH, prize)
    }

    @Test
    fun `로또 당첨 검증 - 6개 일치`() {
        val userLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val prize = LottoPrize.findByMatchCount(6, false)
        assertEquals(LottoPrize.FIRST, prize)
    }
}
