package lotto

import delegate.common.CommonErrorDelegate
import delegate.common.CommonErrorDelegator
import delegate.input.InputErrorDelegate
import delegate.input.InputErrorDelegator
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource
import domain.enums.Exception
import domain.enums.Process
import domain.validator.InputValidator
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.provider.CsvSource

class InputTest {
    private lateinit var commonErrorDelegate: CommonErrorDelegate
    private lateinit var inputErrorDelegate: InputErrorDelegate
    private lateinit var inputValidator: InputValidator

    @BeforeEach
    fun init() {
        commonErrorDelegate = CommonErrorDelegator()
        inputErrorDelegate = InputErrorDelegator()
        inputValidator = InputValidator(commonErrorDelegate, inputErrorDelegate)
    }

    @Nested
    inner class CommonErrorTest {
        @ParameterizedTest
        @EmptySource
        fun `사용자의 입력값이 비어있을 때`(입력: String) {
            Assertions.assertThatThrownBy { commonErrorDelegate.isEmpty(입력) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(Exception.EMPTY_INPUT.toString())
        }
    }

    @Nested
    inner class PurchaseAmountTest {

        @ParameterizedTest
        @ValueSource(strings = ["abc", "ㄱㄴㄷ", "!@#$", "100,23,22"])
        fun `구입 금액 입력값이 숫자가 아닐 때`(value: String) {
            val type = Process.PAY
            Assertions.assertThatThrownBy { commonErrorDelegate.isNumeric(value, type) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage("${type}은(는) ${Exception.INVALID_INPUT}")
        }

        @ParameterizedTest
        @ValueSource(strings = ["0", "9999", "10001", "1111"])
        fun `구입 금액 입력값이 천원 단위가 아닐 때 `(value: String) {
            Assertions.assertThatThrownBy { inputErrorDelegate.isThousandWonUnit(value) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(Exception.INVALID_UNIT.toString())
        }

        @Test
        fun `구입 금액 유효성 검사 후 반환값 테스트`() {
            val value = "5000"
            val expected = Pair("5개를 구매했습니다.", 5)
            Assertions.assertThat(inputValidator.payValidation(value)).isEqualTo(expected)
        }
    }

    @Nested
    inner class WinningNumberTest {

        @ParameterizedTest
        @CsvSource(
            "1;2;3;4;5;6",
            "1.2.3.4.5.6",
            "1^2$3%4#5@6",
            "1-2-3-4-5-6",
            "1_2_3_4_5_6",
        )
        fun `당첨 번호의 구분자가 잘못 입력되었을 때`(value: String) {
            Assertions.assertThatThrownBy { inputErrorDelegate.isInvalidInputFormat(value) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(Exception.INVALID_FORMAT.toString())
        }

        @ParameterizedTest
        @ValueSource(strings = [",,,", ",", "1", "1,2", "1,2,3", "1,2,3,4", "1,2,3,4,5", "1,2,3,4,5,6,7,8,9,10"])
        fun `당첨 번호가 6개가 아닐 때 예외 테스트`(value: String) {
            val winningNumber = value.split(",")
            Assertions.assertThatThrownBy { inputErrorDelegate.isInvalidLottoSize(winningNumber) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(Exception.INVALID_SIZE.toString())
        }

        @ParameterizedTest
        @ValueSource(strings = ["1,2,3,4,5,@", "1,;ㄱ,a,4,5,@"])
        fun `당첨 번호에 숫자와 구분자(쉼표)가 아닌 문자가 입력되었을 때`(value: String) {
            Assertions.assertThatThrownBy { inputErrorDelegate.isInvalidInputFormat(value) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(Exception.INVALID_FORMAT.toString())
        }

        @ParameterizedTest
        @ValueSource(strings = ["0", "46"])
        fun `당첨번호가 로또번호의 범위를 벗어날 때`(value: String){
            val type = Process.WINNING_NUMBER
            Assertions.assertThatThrownBy { inputErrorDelegate.isExceededRange(value, type) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(Exception.EXCEED_INPUT.toString())
        }
    }
}