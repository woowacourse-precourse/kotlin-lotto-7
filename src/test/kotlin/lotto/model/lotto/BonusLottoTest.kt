package lotto.model.lotto

import lotto.model.message.ErrorMessage
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BonusLottoTest {

    @Test
    fun `보너스 번호가 1에서 45 사이의 숫자가 아닐 경우 예외`() {
        // given
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 6)
        val invalidBonusNumber = 46

        // when
        val exception = assertThrows<IllegalArgumentException> {
            BonusLotto(lottoNumbers, invalidBonusNumber)
        }

        //then
        assertEquals(ErrorMessage.INPUT_1_TO_45.message, exception.message)
    }

    @Test
    fun `보너스 번호가 로또 번호와 중복될 경우 예외`() {
        // given
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 6)
        val duplicateBonusNumber = 5

        // when
        val exception = assertThrows<IllegalArgumentException> {
            BonusLotto(lottoNumbers, duplicateBonusNumber)
        }

        //then
        assertEquals(ErrorMessage.INPUT_DUPLICATION_Bonus.message, exception.message)
    }

    @Test
    fun `유효한 보너스 번호가 설정된 경우 보너스 번호가 정상적으로 반환`() {
        // given
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 6)
        val validBonusNumber = 7

        // when
        val bonusLotto = BonusLotto(lottoNumbers, validBonusNumber)

        // then
        assertEquals(validBonusNumber, bonusLotto.getBonusNumber())
    }
}
