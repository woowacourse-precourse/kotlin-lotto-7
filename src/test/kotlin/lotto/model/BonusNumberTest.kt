package lotto.model

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BonusNumberTest {
    private lateinit var lotto: Lotto

    @BeforeEach
    fun setup() {
        lotto = Lotto(listOf(LottoNumber(1), LottoNumber(2),
            LottoNumber(3), LottoNumber(4), LottoNumber(5), LottoNumber(6)))
    }

    @Test
    @DisplayName("보너스 번호가 최솟값보다 작으면 예외가 발생한다.")
    fun bonusNumber_below_minimum_test() {
        assertThrows<IllegalArgumentException> {
            BonusNumber(0, lotto)
        }
    }

    @Test
    @DisplayName("보너스 번호가 최댓값보다 크면 예외가 발생한다.")
    fun bonusNumber_above_maximum_test() {
        assertThrows<IllegalArgumentException> {
            BonusNumber(46, lotto)
        }
    }

    @Test
    @DisplayName("보너스 번호가 음수면 예외가 발생한다.")
    fun bonusNumber_negative_test() {
        assertThrows<IllegalArgumentException> {
            BonusNumber(-1, lotto)
        }
    }

    @Test
    @DisplayName("보너스 번호가 로또 번호와 중복되면 예외가 발생한다.")
    fun bonusNumber_duplicate_test() {
        assertThrows<IllegalArgumentException> {
            BonusNumber(1, lotto)
        }
    }
}
