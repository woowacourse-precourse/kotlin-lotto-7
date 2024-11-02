package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.utils.ErrorMessage
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
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


    @Test
    @DisplayName("구입 금액이 1000원 단위로 입력되지 않으면 예외 메세지 출력")
    fun shouldDisplayErrorMessageForInvalidAmount() {
        setInput("1500\n2000\n")

        // System.out을 캡처하여 출력된 메시지를 확인
        System.setOut(PrintStream(outputStreamCaptor))

        // When: 입력을 시도
        val result = InputView.inputLottoPrice()

        // Then: 올바른 값이 반환되었는지 확인
        assertEquals(2000, result)

        // 출력 메시지 검증
        val output = outputStreamCaptor.toString().trim()
        assertTrue(output.contains(ErrorMessage.INVALID_AMOUNT.getMessage()))
        assert(result == 2000)
    }

    @Test
    @DisplayName("구입 금액에 숫자가 아닌 문자 입력 시 예외 메세지 출력")
    fun shouldDisplayErrorMessageForNotNumber() {
        setInput("abc\n2000\n")

        // System.out을 캡처하여 출력된 메시지를 확인
        System.setOut(PrintStream(outputStreamCaptor))

        // When: 입력을 시도
        val result = InputView.inputLottoPrice()

        // Then: 올바른 값이 반환되었는지 확인
        assertEquals(2000, result)

        // 출력 메시지 검증
        val output = outputStreamCaptor.toString().trim()
        assertTrue(output.contains(ErrorMessage.NOT_NUMBER.getMessage()))
        assert(result == 2000)
    }

    @Test
    @DisplayName("구입 금액이 빈 칸인 경우 예외 메세지 출력")
    fun shouldDisplayErrorMessageForEmptyAmount() {
        setInput("\n2000\n")

        // System.out을 캡처하여 출력된 메시지를 확인
        System.setOut(PrintStream(outputStreamCaptor))

        // When: 입력을 시도
        val result = InputView.inputLottoPrice()

        // Then: 올바른 값이 반환되었는지 확인
        assertEquals(2000, result)

        // 출력 메시지 검증
        val output = outputStreamCaptor.toString().trim()
        assertTrue(output.contains(ErrorMessage.NOT_NUMBER.getMessage()))
        assert(result == 2000)
    }


    @Test
    @DisplayName("올바른 구입 금액 입력 테스트")
    fun shouldReturnCorrectPurchaseAmount() {
        // Given
        setInput("3000\n")
        // Then
        val result: Int = InputView.inputLottoPrice()

        // When
        assert(result == 3000)
    }
}