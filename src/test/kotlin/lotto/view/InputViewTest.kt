package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.utils.ErrorMessage
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.io.PrintStream

class InputViewTest {
    private val originalIn: InputStream = System.`in`
    private val originalOut: PrintStream = System.out
    private val outputStreamCaptor = ByteArrayOutputStream()

    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(outputStreamCaptor))
    }

    @AfterEach
    fun closeConsole() {
        System.setIn(originalIn)
        System.setOut(originalOut)
        Console.close()
    }

    private fun setInput(input: String) {
        System.setIn(ByteArrayInputStream(input.toByteArray()))
    }

    @Nested
    @DisplayName("정상 입력 테스트")
    inner class ValidInputTests {

        @Test
        @DisplayName("올바른 구입 금액 입력 테스트")
        fun shouldReturnCorrectPurchaseAmount() {
            setInput("3000\n")
            val result: Int = InputView.inputLottoPrice()
            assertEquals(3000, result)
        }

        @Test
        @DisplayName("올바른 당첨 번호 입력 테스트")
        fun shouldReturnCorrectWinningNumbers() {
            setInput("1,2,3,4,5,6\n")
            val result: List<Int> = InputView.inputWinningNumbers()
            assertEquals(listOf(1, 2, 3, 4, 5, 6), result)
        }

        @Test
        @DisplayName("올바른 보너스 번호 입력 테스트")
        fun shouldReturnCorrectBonusNumber() {
            setInput("7\n")
            val result: Int = InputView.inputBonusNumber()
            assertEquals(7, result)
        }
    }

    @Nested
    @DisplayName("예외 입력 테스트")
    inner class InvalidInputTests {

        @Test
        @DisplayName("구입 금액이 1000원 단위로 입력되지 않으면 예외 메세지 출력")
        fun shouldDisplayErrorMessageForInvalidAmount() {
            setInput("1500\n2000\n")
            val result = InputView.inputLottoPrice()
            assertEquals(2000, result)

            val output = outputStreamCaptor.toString().trim()
            assertTrue(output.contains(ErrorMessage.INVALID_AMOUNT.getMessage()))
        }

        @Test
        @DisplayName("구입 금액에 숫자가 아닌 문자 입력 시 예외 메세지 출력")
        fun shouldDisplayErrorMessageForNotNumber() {
            setInput("abc\n2000\n")
            val result = InputView.inputLottoPrice()
            assertEquals(2000, result)

            val output = outputStreamCaptor.toString().trim()
            assertTrue(output.contains(ErrorMessage.NOT_NUMBER.getMessage()))
        }

        @Test
        @DisplayName("구입 금액이 빈 칸인 경우 예외 메세지 출력")
        fun shouldDisplayErrorMessageForEmptyAmount() {
            setInput("\n2000\n")
            val result = InputView.inputLottoPrice()
            assertEquals(2000, result)

            val output = outputStreamCaptor.toString().trim()
            assertTrue(output.contains(ErrorMessage.NOT_NUMBER.getMessage()))
        }

        @Test
        @DisplayName("로또 번호가 6개가 아닌 경우 예외 메세지 출력")
        fun shouldDisplayErrorMessageForInvalidLottoNumbers() {
            setInput("1,2,3,4,5\n1,2,3,4,5,6\n")
            val result = InputView.inputWinningNumbers()
            assertEquals(listOf(1, 2, 3, 4, 5, 6), result)

            val output = outputStreamCaptor.toString().trim()
            assertTrue(output.contains(ErrorMessage.INVALID_LOTTO_NUMBERS.getMessage()))
        }

        @Test
        @DisplayName("로또 번호가 숫자가 아닌 경우 예외 메세지 출력")
        fun shouldDisplayErrorMessageForNotNumberInLottoNumbers() {
            setInput("1,2,3,4,5,a\n1,2,3,4,5,6\n")
            val result = InputView.inputWinningNumbers()
            assertEquals(listOf(1, 2, 3, 4, 5, 6), result)

            val output = outputStreamCaptor.toString().trim()
            assertTrue(output.contains(ErrorMessage.NOT_NUMBER.getMessage()))
        }

        @Test
        @DisplayName("로또 번호가 1~45 사이의 숫자가 아닌 경우 예외 메세지 출력")
        fun shouldDisplayErrorMessageForInvalidLottoNumber() {
            setInput("1,2,3,4,5,46\n1,2,3,4,5,6\n")
            val result = InputView.inputWinningNumbers()
            assertEquals(listOf(1, 2, 3, 4, 5, 6), result)

            val output = outputStreamCaptor.toString().trim()
            assertTrue(output.contains(ErrorMessage.INVALID_LOTTO_NUMBER.getMessage()))
        }

        @Test
        @DisplayName("로또 번호가 중복되는 경우 예외 처리")
        fun shouldDisplayErrorMessageForDuplicatedLottoNumber() {
            setInput("1,2,3,4,5,5\n1,2,3,4,5,6\n")
            val result = InputView.inputWinningNumbers()
            assertEquals(listOf(1, 2, 3, 4, 5, 6), result)

            val output = outputStreamCaptor.toString().trim()
            assertTrue(output.contains(ErrorMessage.INVALID_DUPLICATE_NUMBER.getMessage()))
        }

        @Test
        @DisplayName("보너스 번호가 1~45 사이의 숫자가 아닌 경우 예외 메세지 출력")
        fun shouldDisplayErrorMessageForInvalidBonusNumber() {
            setInput("46\n1\n")
            val result = InputView.inputBonusNumber()
            assertEquals(1, result)

            val output = outputStreamCaptor.toString().trim()
            assertTrue(output.contains(ErrorMessage.INVALID_BONUS_NUMBER.getMessage()))
        }
    }
}