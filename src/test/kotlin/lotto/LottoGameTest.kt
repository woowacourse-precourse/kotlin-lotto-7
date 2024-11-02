package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest


class LottoGameTest {

    companion object {
        private const val ERROR_MESSAGE: String = "[ERROR]"
    }

    private val lottoGame = LottoGame()

    @Test
    fun `유효한 구입 금액을 입력하면 해당 금액을 반환한다`() {
        val cost = 3000
        assertThat(lottoGame.inputCost()).isEqualTo(cost)
    }

    @Test
    fun `금액이 1000원 미만이면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            lottoGame.inputCost()
        }
    }

    @Test
    fun `금액이 1000 단위가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            lottoGame.inputCost()
        }
    }


}