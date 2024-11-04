package lotto

import lotto.domain.Lotto
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
    fun `로또 번호의 숫자 범위는 1~45까지이다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 100))
        }
    }

    @Test
    fun `로또 1장의 가격은 1,000원이다`() {
        assert(Lotto.PRICE == 1_000)
    }

    @Test
    fun `로또 번호는 오름차순으로 정렬하여 보여준다`() {
        assert(listOf(1, 2, 3, 4, 5, 6) == Lotto(listOf(6, 5, 4, 3, 2, 1)).getNumbers())
    }
}
