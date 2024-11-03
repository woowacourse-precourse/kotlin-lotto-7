package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows

class LottoTest {

    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }
}

class InputTest {

    private val input = Input()

    @Test
    fun `올바른 금액을 입력하여 티켓 수를 계산할 수 있다`() {
        input.ticket = input.confirmDivider(5000)
        assertEquals(5, input.ticket)
    }

    @Test
    fun `1000원 단위가 아닌 금액 입력 시 예외 발생`() {
        assertThrows<CustomErrorHandler> {
            input.confirmDivider(5500)
        }
    }

    @Test
    fun `로또 번호 입력 시 중복된 번호가 있으면 예외 발생`() {
        assertThrows<CustomErrorHandler> {
            input.checkLottoDuplicate(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `보너스 번호가 당첨 번호와 중복되면 예외 발생`() {
        input.correctIntLotto = listOf(1, 2, 3, 4, 5, 6)
        assertThrows<CustomErrorHandler> {
            input.checkBonusDuplicate(5)
        }
    }
}

class OutputTest {

    private val output = Output()


    @Test
    fun `수익률 계산이 올바르게 동작하는지 확인`() {
        val result = output.rateCalc(6000, 8000)
        assertEquals(75.0, result)
    }
}

class LottoIntegrationTest {

    private val input = Input()

    @Test
    fun `로또 게임 통합 테스트`() {
        input.ticket = 3
        input.lottos = mutableListOf(
            mutableListOf(1, 2, 3, 4, 5, 6),
            mutableListOf(7, 8, 9, 10, 11, 12),
            mutableListOf(13, 14, 15, 16, 17, 18)
        )

        input.correctLotto = listOf("1", "2", "3", "4", "5", "6")
        input.correctIntLotto = input.correctLotto.map { it.toInt() }

        input.lotto = Lotto(input.correctIntLotto)
        input.inputBonusNumber()
        input.checkList()
    }
}
