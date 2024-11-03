package lotto

import lotto.Model.Lotto
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {
    @Test
    fun `로또 번호 개수가 6개 이상 - 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `중복된 로또 번호 - 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `로또 번호 개수 6개 이하 - 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `로또 번호 오류(1~45의 값이 아닌 경우) - 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(0, 2, 3, 4, 5, 6))
        }
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 46))
        }
    }

    @Test
    fun `로또 번호가 음수인 경우 - 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(-1, 2, 3, 4, 5, 6))
        }
    }
}
