package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat

class LottoJudgeTest {
    private lateinit var lottoJudge: LottoJudge

    @BeforeEach
    fun setUp() {
        lottoJudge = LottoJudge()
    }

    @Test
    fun `로또 당첨 번호를 입력할 수 있어야 한다`() {
        lottoJudge.setLottoWinnerNumbers(listOf(1,2,3,4,5,6))
    }

    @Test
    fun `로또 당첨 번호는 6개 입력되어야 한다`() {
        val exceptionForNumbersCountIsSeven = `로또 당첨 번호가 7개인 경우 예외가 발생해야 한다`()
        assertThat(exceptionForNumbersCountIsSeven.message).contains(ErrorMessage.INPUT_WINNER_NUMBER_COUNT_ERROR.getMessage())

        val exceptionForNumbersCountIsFive = `로또 당첨 번호가 5개인 경우 예외가 발생해야 한다`()
        assertThat(exceptionForNumbersCountIsFive.message).contains(ErrorMessage.INPUT_WINNER_NUMBER_COUNT_ERROR.getMessage())
    }

    private fun `로또 당첨 번호가 7개인 경우 예외가 발생해야 한다`(): Exception {
        val exception = assertThrows<IllegalArgumentException> {
            lottoJudge.setLottoWinnerNumbers(listOf(1,2,3,4,5,6,7))
        }

        return exception
    }

    private fun `로또 당첨 번호가 5개인 경우 예외가 발생해야 한다`(): Exception {
        val exception = assertThrows<IllegalArgumentException> {
            lottoJudge.setLottoWinnerNumbers(listOf(1,2,3,4,5))
        }

        return exception
    }

    @Test
    fun `로또 당첨 번호는 1 이상, 45 이하로 입력되어야 한다`() {
        val exceptionForNumbersMinus = `로또 당첨 번호가 1미만인 경우 예외가 발생해야 한다`()
        assertThat(exceptionForNumbersMinus.message).contains(ErrorMessage.INPUT_WINNER_NUMBER_OUT_OF_RANGE_ERROR.getMessage())

        val exceptionForNumbersAboveFortyFive = `로또 당첨 번호가 45초과인 경우 예외가 발생해야 한다`()
        assertThat(exceptionForNumbersAboveFortyFive.message).contains(ErrorMessage.INPUT_WINNER_NUMBER_OUT_OF_RANGE_ERROR.getMessage())
    }

    private fun `로또 당첨 번호가 1미만인 경우 예외가 발생해야 한다`(): Exception {
        val exception = assertThrows<IllegalArgumentException> {
            lottoJudge.setLottoWinnerNumbers(listOf(-1,2,3,4,5,6))
        }

        return exception
    }

    private fun `로또 당첨 번호가 45초과인 경우 예외가 발생해야 한다`(): Exception {
        val exception = assertThrows<IllegalArgumentException> {
            lottoJudge.setLottoWinnerNumbers(listOf(1,2,3,4,46))
        }

        return exception
    }

    @Test
    fun `보너스 번호는 1개 입력되어야 한다`() {
        lottoJudge.setLottoBonusNumber(1)
    }

    @Test
    fun `보너스 번호는 1 이상, 45 이하로 입력되어야 한다`() {
        val exceptionForBonusNumberLessThanOne = `보너스 번호가 1미만인 경우 예외가 발생해야 한다`()
        assertThat(exceptionForBonusNumberLessThanOne.message).contains(ErrorMessage.INPUT_WINNER_NUMBER_OUT_OF_RANGE_ERROR.getMessage())

        val exceptionForBonusNumberGreaterThanFortyFive = `보너스 번호가 45초과인 경우 예외가 발생해야 한다`()
        assertThat(exceptionForBonusNumberGreaterThanFortyFive.message).contains(ErrorMessage.INPUT_WINNER_NUMBER_OUT_OF_RANGE_ERROR.getMessage())
    }

    private fun `보너스 번호가 1미만인 경우 예외가 발생해야 한다`(): Exception {
        val exception = assertThrows<IllegalArgumentException> {
            lottoJudge.setLottoBonusNumber(0)
        }

        return exception
    }

    private fun `보너스 번호가 45초과인 경우 예외가 발생해야 한다`(): Exception {
        val exception = assertThrows<IllegalArgumentException> {
            lottoJudge.setLottoBonusNumber(46)
        }

        return exception
    }
}