package lotto

import lotto.model.Lotto
import lotto.validator.InputValidator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputValidTest {
    val validator = InputValidator()

    @Test
    fun `구매 금액이 1000으로 나눠 떨어지지 않는 경우`() {
        assertThrows<IllegalArgumentException> {
            validator.isValidMoney("14500")
        }
    }

    @Test
    @DisplayName("ex) 4,000 -> 4000, 40,00 -> Error ")
    fun `구매 금액 표기가 잘못 된 경우`() {
        assertThrows<IllegalArgumentException> {
            validator.isValidMoney("40,00")
        }
    }

    @Test
    fun `당첨 번호가 6개가 아닌 경우`() {
        assertThrows<IllegalArgumentException> {
            validator.isValidWinningNum("")
            validator.isValidWinningNum("1,2,3")
            validator.isValidWinningNum("1,2,3,4,5,6,7")
        }
    }
    @Test
    fun `당첨 번호에 중복된 값이 입력된 경우`(){
        assertThrows<IllegalArgumentException> {
            validator.isValidWinningNum("1,2,3,3,4,5")
            validator.isValidWinningNum("1,2,2,2,4,3")
            validator.isValidWinningNum("1,2,3,4,2,5")
        }
    }

    @Test
    fun`당첨 번호가 1에서 45 사이가 아닌 경우`(){
        assertThrows<IllegalArgumentException> {
            validator.isValidWinningNum("1,2,3,4,45,47")
            validator.isValidWinningNum("1,46,0,2,3,4")
        }
    }

    @Test
    fun`보너스 번호가 1에서 45사이가 아닌 경우`(){
        assertThrows<IllegalArgumentException> {
            validator.isValidBonusNum("0", listOf(1,2,3,4,5,6))
            validator.isValidBonusNum("46", listOf(1,2,3,4,5,6))
        }
    }
    @Test
    fun`보너스 번호가 당첨 번호와 중복되는 경우`(){
        assertThrows<IllegalArgumentException> {
            validator.isValidBonusNum("4", listOf(1,2,3,4,5,6))
        }
    }
}