package lotto

import lotto.model.Lotto
import org.junit.jupiter.api.Assertions.assertEquals
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
    fun `로또 번호가 유효하지 않은 범위를 가지면 예외가 발생`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(0, 1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `로또 번호가 정상적으로 생성`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertEquals(6, lotto.getNumbers().size)
        assertTrue(lotto.getNumbers().containsAll(listOf(1, 2, 3, 4, 5, 6)))
    }

    @Test
    fun `로또 번호가 오름차순으로 정렬`() {
        val lotto = Lotto(listOf(5, 1, 3, 2, 6, 4))
        assertEquals(listOf(1, 2, 3, 4, 5, 6), lotto.getNumbers().sorted())
    }
}