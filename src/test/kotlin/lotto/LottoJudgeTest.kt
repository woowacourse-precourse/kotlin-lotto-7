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
        val exception = assertThrows<IllegalArgumentException> {
            lottoJudge.setLottoWinnerNumbers(listOf(1,2,3,4,5,6,7))
        }

        assertThat(exception.message).contains(ErrorMessage.INPUT_WINNER_NUMBER_COUNT_ERROR.getMessage())
    }
}