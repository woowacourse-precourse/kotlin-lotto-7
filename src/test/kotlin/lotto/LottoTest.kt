package lotto

import lotto.model.Lotto
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {
    @Test
    fun `로또 안의 숫자가 1~45사이의 숫자가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(-1, 2, 3, 4, 5, 6))
        }
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 4, 5, 6, 333))
        }
    }

    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `로또 번호의 개수가 6개 미만이면 예외가 발생한다`() {
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
    fun `로또 번호가 오름차순이 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 3, 2, 4, 5, 6))
        }
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
    @Test
    fun `getNumbers 함수에서 list가 정상 반환되는지 확인`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertEquals(lotto.getNumbers(), listOf(1, 2, 3, 4, 5, 6))
    }

    @Test
    fun `toString 함수가 해쉬코드가 아닌 값을 반환하는지 확인`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertEquals(lotto.toString(), "[1, 2, 3, 4, 5, 6]")

    }
}
