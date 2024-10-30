package lotto

import delegate.common.CommonErrorDelegate
import delegate.common.CommonErrorDelegator
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import util.Exception
import view.InputView

class InputTest {
    private lateinit var commonErrorDelegate: CommonErrorDelegate

    @BeforeEach
    fun init(){
        commonErrorDelegate = CommonErrorDelegator()
    }

    @ParameterizedTest
    @EmptySource
    fun `입력값이 비어잇을 때`(입력: String){
        Assertions.assertThatThrownBy{ commonErrorDelegate.isEmpty(입력) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(Exception.EMPTY_INPUT.toString())
    }
}