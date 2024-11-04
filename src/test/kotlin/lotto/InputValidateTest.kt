package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class InputValidateTest: NsTest() {

    @Test
    fun testPurchaseAmountNotDivideLottoCost() {
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

    @Test
    fun testPurchaseAmountOverFlow() {
        assertSimpleTest {
            runException("150000000000000000")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun testWinningLottoNotSize6() {
        assertSimpleTest {
            runException("5000", "1,2,3,4,5,6,7")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun testWinningLottoNotDigit() {
        assertSimpleTest {
            runException("5000", "a,b,c,d,e,f,g")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun testBonusNumberNotDigit() {
        assertSimpleTest {
            runException("5000", "1,2,3,4,5,6", "a")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun testBonusNumberNotRightRange() {
        assertSimpleTest {
            runException("5000", "1,2,3,4,5,6", "50")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun testBonusNumberDuplicateWithWinningLotto() {
        assertSimpleTest {
            runException("5000", "1,2,3,4,5,6", "6")
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