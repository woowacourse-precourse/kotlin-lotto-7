package lotto.model

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
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `로또 번호에 1~45 사이의 숫자가 아닌 번호가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 50))
        }
    }

    @Test
    fun `getLottoNumbers를 호출하면 오름차순 정렬된 로또 번호를 반환한다`() {
        val lotto = Lotto(listOf(2, 1, 5, 3, 6, 4))
        val expected = listOf(1, 2, 3, 4, 5, 6)

        val result = lotto.getLottoNumbers()

        assertEquals(expected, result)
    }
}
