package lotto

import camp.nextstep.edu.missionutils.test.Assertions
import lotto.model.Lotto
import lotto.view.InputView
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BonusLottoTest {


    @Test
    fun `보너스 로또 번호가 1~45 사이의 숫자가 아닐 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            val winLotto = listOf(1, 2, 3, 4, 5, 6)
//            val bonusLotto = inputView.printInputBonusLotteryNumber(winLotto)
            Validator.validateBonusLottery(winLotto, "66")

        }
    }

    @Test
    fun `보너스 로또 번호가 당첨 복권 번호와 중복될 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            val winLotto = listOf(1, 2, 3, 4, 5, 6)
//            val bonusLotto = inputView.printInputBonusLotteryNumber(winLotto)
            Validator.validateBonusLottery(winLotto, "1")

        }
    }
}