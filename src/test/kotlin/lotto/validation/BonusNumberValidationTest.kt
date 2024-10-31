package lotto.validation

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import utils.validator.BonusNumberValidator

class BonusNumberValidationTest {
    @Test
    fun `보너스 번호는 숫자이어야 한다`() {
        val bonusNumber = "보너스"

         assertThrows<IllegalArgumentException> {
             BonusNumberValidator.SHOULD_BE_NUMBER.validate(bonusNumber)
         }
    }
    @Test
    fun `보너스 번호는 1~45 사이의 숫자이어야 한다`(){
        val bonusNumber = "46"

        assertThrows<IllegalArgumentException> {
            BonusNumberValidator.SHOULD_BE_1_TO_45_NUMBER.validate(bonusNumber)
        }
    }
    @Test
    fun `보너스 번호는 당첨 번호와 중복되어서는 안된다`(){
        val bonusNumber = "1"
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)

        assertThrows<IllegalArgumentException> {
            BonusNumberValidator.SHOULD_NOT_BE_DUPLICATE.validate(bonusNumber, winningNumbers)
        }
    }

}