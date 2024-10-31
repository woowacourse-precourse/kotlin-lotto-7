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
import org.junit.jupiter.api.Test

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

    @ParameterizedTest
    @EmptySource
    fun `구입금액 입력값이 비어있을 때`(입력: String) {
        Assertions.assertThatThrownBy { commonErrorDelegate.isEmpty(입력) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(Exception.EMPTY_INPUT.toString())
    }

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
    fun `구입 금액 유효성 검사 후 반환값 테스트`(){
        val value = "5000"
        val expected = Pair("5개를 구매했습니다.", 5)
        Assertions.assertThat(inputValidator.payValidation(value)).isEqualTo(expected)
    }
}