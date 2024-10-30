package lotto

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import util.Exception
import view.InputView

class InputTest {
    private lateinit var view: InputView

    @BeforeEach
    fun init(){
        view = InputView()
    }

    @ParameterizedTest
    @EmptySource
    fun `입력값이 비어잇을 때`(입력: String){
        Assertions.assertThatThrownBy{ view.isEmpty(입력) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(Exception.EMPTY_INPUT.toString())
    }
}