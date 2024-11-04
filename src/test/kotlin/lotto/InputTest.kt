package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class InputTest : NsTest() {
    @Test
    fun `구매 금액에 입력값이 없을 경우 예외를 발생시킨다`() {
        assertSimpleTest {
            runException(null)
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `구매 금액이 정수가 아닌 경우 예외를 발생시킨다`() {
        assertSimpleTest {
            runException("1000.2")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `구매 금액이 1000원 미만인 경우 예외를 발생시킨다`() {
        assertSimpleTest {
            runException("500")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `구매 금액이 1000원 단위가 아닌 경우 예외를 발생시킨다`() {
        assertSimpleTest {
            runException("1500")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `당첨 번호에 입력값이 없는 경우 예외를 발생시킨다`() {
        assertSimpleTest {
            runException("1000", null)
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `당첨 로또 번호의 개수가 6개가 아닌 경우 예외를 발생시킨다`() {
        assertSimpleTest {
            runException("1000","1,2,3,4,5")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `당첨 로또 번호가 숫자가 아닌 경우 예외를 발생시킨다`() {
        assertSimpleTest {
            runException("1000","1,2,3,4,5,a")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `당첨 로또 번호가 1~45 사이의 값이 아닌 경우 예외를 발생시킨다`() {
        assertSimpleTest {
            runException("1000","1,2,3,4,5,55")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `당첨 로또 번호중 중복된 값이 있는 경우 예외를 발생시킨다`() {
        assertSimpleTest {
            runException("1000","1,2,3,4,5,5")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `보너스 번호에 입력값이 없는 경우 예외를 발생시킨다`() {
        assertSimpleTest {
            runException("1000","1,2,3,4,5,6",null)
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `보너스 번호가 숫자가 아닌 경우 예외를 발생시킨다`() {
        assertSimpleTest {
            runException("1000","1,2,3,4,5,6","a")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `보너스 번호가 1~45 사이의 값이 아닌 경우 예외를 발생시킨다`() {
        assertSimpleTest {
            runException("1000","1,2,3,4,5,6","55")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }
    @Test
    fun `보너스 번호가 당첨 번호와 중복될 경우 예외를 발생시킨다`() {
        assertSimpleTest {
            runException("1000","1,2,3,4,5,6","5")
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