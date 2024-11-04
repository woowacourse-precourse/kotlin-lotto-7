package lotto

import control.BonusNumberValidator
import control.PurchaseAmountValidator
import data.Bonus
import data.Lotto
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }
    // TODO: 테스트가 통과하도록 프로덕션 코드 구현
    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `당첨 번호의 범위는 1~45 이어야 한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 55))
        }
    }

    @Test
    fun `보너스 번호의 범위는 1~45 이어야 한다`() {
        assertThrows<IllegalArgumentException> {
            Bonus(48)
        }
    }

    @Test
    fun `보너스 번호는 당첨 번호와 중복되면 안된다`() {
        assertThrows<IllegalArgumentException> {
            BonusNumberValidator().checkDuplicateTest("6", Lotto(listOf(1, 2, 3, 4, 5, 6)))
        }
    }

    @Test
    fun `구입 금액은 천원 단위 여야 한다`() {
        assertThrows<IllegalArgumentException> {
            PurchaseAmountValidator().checkDivideTest("5500")
        }
    }
    @Test
    fun `Int 최대값을 벗어나면 안된다`() {
        assertThrows<ArithmeticException> {
            PurchaseAmountValidator().checkIntRangeTest("3000000000")
        }
    }
}