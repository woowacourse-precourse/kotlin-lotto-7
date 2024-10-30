package lotto

import delegate.common.CommonErrorDelegate
import delegate.common.CommonErrorDelegator
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource
import util.Exception
import util.Process

class InputTest {
    private lateinit var commonErrorDelegate: CommonErrorDelegate

    @BeforeEach
    fun init() {
        commonErrorDelegate = CommonErrorDelegator()
    }

    @ParameterizedTest
    @EmptySource
    fun `입력값이 비어잇을 때`(입력: String) {
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

}