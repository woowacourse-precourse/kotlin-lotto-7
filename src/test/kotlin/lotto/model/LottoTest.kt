package lotto.model

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
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

    @Nested
    @DisplayName("로또 번호가 1~45 범위를 초과하면 예외가 발생한다")
    inner class RangeTest {
        @Test
        fun `로또 번호에 음수가 존재하면 예외가 발생한다`() {
            assertThrows<IllegalArgumentException> {
                Lotto(listOf(-1, 1, 2, 3, 4, 5))
            }
        }

        @Test
        fun `로또 번호에 0이 존재하면 예외가 발생한다`() {
            assertThrows<IllegalArgumentException> {
                Lotto(listOf(0, 1, 2, 3, 4, 5))
            }
        }

        @Test
        fun `로또 번호가 45를 초과하면 예외가 발생한다`() {
            assertThrows<IllegalArgumentException> {
                Lotto(listOf(1, 2, 3, 4, 5, 46))
            }
        }
    }
}
