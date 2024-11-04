package lotto

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

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
    @Test
    fun `로또 번호의 개수가 6개 이하면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `로또 번호가 1~45까지의 숫자가 아닌 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 55))
        }

        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 0))
        }
    }

    @Test
    fun `보너스 번호가 1~45까지의 숫자가 아닌 경우 예외가 발생한다`() {

        assertThrows<IllegalArgumentException> {
            val bonusLottoNum = 46
            InputValidation().checkBonusLottoNum(bonusLottoNum)
        }

        assertThrows<IllegalArgumentException> {
            val bonusLottoNum = 0
            InputValidation().checkBonusLottoNum(bonusLottoNum)
        }
    }

    @Test
    fun `당첨 번호 및 보너스 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        val lottoNum = listOf(1, 2, 3, 4, 5, 6)
        val bonusLottoNum = 1

        assertThrows<IllegalArgumentException> {
            InputValidation().checkDuplicate(lottoNum, bonusLottoNum)
        }
    }

    @Test
    fun `로또 구입 금액이 1,000원으로 나누어 떨어지지 않으면 예외가 발생한다`() {
        val lottoPayment = 1500

        assertThrows<IllegalArgumentException> {
            InputValidation().checkPayment(lottoPayment)
        }
    }
}
