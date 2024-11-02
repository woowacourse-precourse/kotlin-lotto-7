package validator

import camp.nextstep.edu.missionutils.test.NsTest
import lotto.main
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class InputValidatorTest : NsTest() {
    @Test
    fun `입력값이 비어있거나 공백 문자로만 구성되면 예외가 발생한다`() {
        InputValidator().inputCheck("")
        assertThat(output()).contains(ErrorMessage.INPUT_IS_NULL.getMessage())
    }

    @Test
    fun `입력값이 정수가 아니면 예외가 발생한다`() {
        InputValidator().inputCheck("1000.5")
        assertThat(output()).contains(ErrorMessage.INPUT_NOT_NUMBER.getMessage())
    }

    override fun runMain() {
        main()
    }
}