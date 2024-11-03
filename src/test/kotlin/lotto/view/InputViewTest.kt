package lotto.view

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputViewTest {
    @Test
    fun `구매 금액은 0보다 큰 수이여야 한다`(){
        assertThrows<IllegalArgumentException> {
            InputView().validatePurchaseAmount(-1)
        }
    }
    @Test
    fun `구매 금액은 1000원 단위로 입력되어야한다`(){
        assertThrows<IllegalArgumentException> {
            InputView().validatePurchaseAmount(1234)
        }
    }
    @Test
    fun `6개의 당첨 번호를 입력 받아야한다`(){
        val numbers = listOf(1,2,3,4,5,6,7)
        assertThrows<IllegalArgumentException> {
            InputView().validateWinningNumbers(numbers)
        }
    }
    @Test
    fun `당첨 번호는 1에서 45 사이의 숫자여야 한다`(){
        val numbers = listOf(1,2,3,4,5,46)
        assertThrows<IllegalArgumentException> {
            InputView().validateWinningNumbers(numbers)
        }
    }
    @Test
    fun `당첨 번호는 중복될 수 없다`(){
        val numbers = listOf(1,3,3,4,5,6)
        assertThrows<IllegalArgumentException> {
            InputView().validateWinningNumbers(numbers)
        }
    }
    @Test
    fun `보너스 번호는 1에서 45 사이의 숫자여야 한다`(){
        val number = 46
        assertThrows<IllegalArgumentException> {
            InputView().validateBonusNumber(number)
        }
    }
}