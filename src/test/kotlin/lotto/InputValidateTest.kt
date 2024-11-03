package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class InputValidateTest : NsTest() {
    @Test
    fun `구입금액이 1000원으로 나누어 떨어지지 않을 때`() {
        assertSimpleTest {
            runException("1500")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `구입금액이 숫자가 아닐 때`() {
        assertSimpleTest {
            runException("1500j")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `당첨 번호가 6개의 숫자가 아닐 때`() {
        assertSimpleTest {
            runException("5000", "1,2,3,4,5,6,7")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `당첨 번호에 숫자가 아닌 값이 포함될 때`() {
        assertSimpleTest {
            runException("5000", "a,b,c,d,e,f")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `보너스 번호가 숫자가 아닐 때`() {
        assertSimpleTest {
            runException("5000", "1,2,3,4,5,6", "a")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `보너스 번호가 1부터 45 사이가 아닐 때`() {
        assertSimpleTest {
            runException("5000", "1,2,3,4,5,6", "50")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `보너스 번호가 당첨 번호와 중복될 때`() {
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