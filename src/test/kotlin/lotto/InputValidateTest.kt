package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import lotto.View.InputView
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class InputValidateTest: NsTest() {
    private val inputView = InputView()

    @Test
    fun testPurchaseAmountNotDivide1000() {
        assertSimpleTest {
            runException("1500")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun testPurchaseAmountNotDigit() {
        assertSimpleTest {
            runException("1500j")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val ERROR_MESSAGE: String = "[ERROR]"
    }
}