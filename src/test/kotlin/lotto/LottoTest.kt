package lotto

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
    fun `로또 번호가 1 이상 45 이하의 범위를 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 100))
        }
    }

    @Test
    fun `구입 금액을 1,000원 단위로 입력하지 않으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            checkAmount("1234")
        }
    }

    @Test
    fun `구입 금액에 정수 이외의 문자열을 입력하면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            checkAmount("1000abc")
        }
    }

    @Test
    fun `당첨 번호에 쉼표가 아닌 다른 구분자를 입력하면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            getWinningLotto("1;2;3;4;5;6")
        }
    }

    @Test
    fun `보너스 번호가 1 이상 45 이하의 범위를 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            checkNumber("46")
        }
    }

    @Test
    fun `보너스 번호에 정수 이외의 문자열을 입력하면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            checkNumber("1a")
        }
    }
}
