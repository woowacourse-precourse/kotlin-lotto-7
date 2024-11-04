package lotto.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoNumberTest {
    @Test
    @DisplayName("숫자가 유효하면 로또 번호가 생성된다.")
    fun valid_number_test() {
        val lottoNumber = LottoNumber(1)
        assertEquals(1, lottoNumber.number)

        val lottoNumber2 = LottoNumber(45)
        assertEquals(45, lottoNumber2.number)
    }

    @Test
    @DisplayName("숫자가 최솟값보다 작으면 예외가 발생한다.")
    fun lottoNumber_below_minimum_test() {
        assertThrows<IllegalArgumentException> {
            LottoNumber(0)
        }
    }

    @Test
    @DisplayName("숫자가 최댓값보다 크면 예외가 발생한다.")
    fun lottoNumber_above_maximum_test() {
        assertThrows<IllegalArgumentException> {
            LottoNumber(46)
        }
    }

    @Test
    @DisplayName("숫자가 음수면 예외가 발생한다.")
    fun lottoNumber_negative_test() {
        assertThrows<IllegalArgumentException> {
            LottoNumber(-1)
        }
    }
}

