package lotto.view

import lotto.model.Lotto
import lotto.util.Constants
import lotto.util.Prize
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class OutputTest {

    private val outputStreamCaptor = ByteArrayOutputStream()

    init {
        System.setOut(PrintStream(outputStreamCaptor))
    }

    @Test
    fun `출력 테스트 - 당첨 결과 출력`() {
        val winningDetails = listOf(1, 0, 2, 0, 1)
        Output.printWinningDetails(winningDetails)

        val output = outputStreamCaptor.toString().trim().split("\n")
        assertThat(output).contains(
            Constants.WINNING_DETAIL,
            Constants.DASH,
            "3개 일치 (5,000원) - 1개",
            "4개 일치 (50,000원) - 0개",
            "5개 일치 (1,500,000원) - 2개",
            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
            "6개 일치 (2,000,000,000원) - 1개"
        )
    }

    @Test
    fun `출력 테스트 - 로또 번호 출력`() {
        val lottoes = listOf(Lotto(listOf(1, 2, 3, 4, 5, 6)), Lotto(listOf(7, 8, 9, 10, 11, 12)))
        Output.printLottoDetails(lottoes)

        val output = outputStreamCaptor.toString().trim().split("\n")
        assertThat(output).containsExactly(
            "[1, 2, 3, 4, 5, 6]",
            "[7, 8, 9, 10, 11, 12]"
        )
    }

    @Test
    fun `출력 테스트 - 수익률 출력`() {
        val rate = 75.0
        Output.printReturnRate(rate)

        val output = outputStreamCaptor.toString().trim()
        assertThat(output).isEqualTo("${Constants.RETURN_RATE}75.0${Constants.IS_PERCENT}")
    }

    @Test
    fun `출력 테스트 - 금액 입력 요청`() {
        Output.printMoneyToInput()

        val output = outputStreamCaptor.toString().trim()
        assertThat(output).isEqualTo(Constants.INSERT_MONEY)
    }

    @Test
    fun `출력 테스트 - 구매 결과 출력`() {
        val money = 12000
        Output.printPurchaseDetails(money)

        val output = outputStreamCaptor.toString().trim()
        assertThat(output).isEqualTo("12${Constants.INSERT_MONEY_RESULT}")
    }

    @Test
    fun `출력 테스트 - 당첨 번호 입력 요청`() {
        Output.printWinningNumberToInput()

        val output = outputStreamCaptor.toString().trim()
        assertThat(output).isEqualTo(Constants.INSERT_WINNING_NUNBER)
    }

    @Test
    fun `출력 테스트 - 보너스 번호 입력 요청`() {
        Output.printBonusNumberToInput()

        val output = outputStreamCaptor.toString().trim()
        assertThat(output).isEqualTo(Constants.INSERT_BONUS_NUMBER)
    }
}
