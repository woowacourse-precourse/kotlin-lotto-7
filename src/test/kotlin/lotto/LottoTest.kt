package lotto

import lotto.domain.entity.Lotto
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

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
    fun `로또 번호의 개수가 6개보다 적으면 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5))
        }
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "0,1,2,3,4,5",
            "1,2,3,4,5,50"
        ]
    )
    fun `로또 번호가 범위를 벗어나면 예외 발생`(numbers: String) {
        val lottoNums = numbers.split(',').map { it.toInt() }
        assertThrows<IllegalArgumentException> { Lotto(lottoNums) }
    }
}
