package lotto

import lotto.domain.entity.Lotto
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class WinningNumbersTest {
    @Test
    fun `당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `당첨 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 46, -10, 100])
    fun `당첨 번호가 1~45가 아닐 경우 예외가 발생한다`(exceptionNumber: Int) {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(exceptionNumber, 1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `당첨 번호들이 오름차순이 아닐 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 5, 4, 7))
        }
    }
}