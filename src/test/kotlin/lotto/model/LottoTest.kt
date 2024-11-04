package lotto.model

import lotto.model.Lotto
import lotto.model.LottoNumber
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {
    @Test
    @DisplayName("로또 번호의 개수가 6개 미만이면 예외가 발생한다")
    fun lotto_less_size_test() {
        val numbers = listOf(LottoNumber(1), LottoNumber(2), LottoNumber(3), LottoNumber(4), LottoNumber(5))
        assertThrows<IllegalArgumentException> {
            Lotto(numbers)
        }
    }

    @Test
    @DisplayName("로또 번호의 개수가 6개 이상이면 예외가 발생한다")
    fun lotto_more_size_test() {
        val numbers = listOf(LottoNumber(1), LottoNumber(2), LottoNumber(3), LottoNumber(4),
            LottoNumber(5), LottoNumber(6), LottoNumber(7))
        assertThrows<IllegalArgumentException> {
            Lotto(numbers)
        }
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다")
    fun lotto_duplicate_test() {
        val numbers = listOf(LottoNumber(1), LottoNumber(2), LottoNumber(3), LottoNumber(4), LottoNumber(5), LottoNumber(5))
        assertThrows<IllegalArgumentException> {
            Lotto(numbers)
        }
    }
}
