package lotto

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

    // TODO: 테스트가 통과하도록 프로덕션 코드 구현
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
}
