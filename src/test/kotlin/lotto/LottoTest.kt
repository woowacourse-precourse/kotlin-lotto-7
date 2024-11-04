package lotto

import lotto.model.Lotto
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
    fun `로또 번호의 개수가 6개보다 부족하면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(7,3,4,5))
        }
    }

    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `로또 번호가 1~45 범위를 벗어날 경우 예외가 발생한다 `() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(12, 2, 3, 47, 55, 5))
        }
    }
}
