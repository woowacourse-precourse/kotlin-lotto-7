package lotto

import lotto.model.Lotto
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `로또 번호의 개수가 6개가 보다 적으면 예외가 발생한다`() {
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

    @ParameterizedTest
    @MethodSource("provideInvalidNumbers")
    fun `로또 번호는 1 ~ 45사이에 숫자만 가능하다`(numbers: List<Int>) {
        assertThrows<IllegalArgumentException> {
            Lotto(numbers)
        }
    }

    companion object {
        @JvmStatic
        fun provideInvalidNumbers(): List<List<Int>> {
            return listOf(
                listOf(-1, 2, 3, 4, 5, 6),
                listOf(1, 2, 3, 4, 5, 46)
            )
        }
    }
}
