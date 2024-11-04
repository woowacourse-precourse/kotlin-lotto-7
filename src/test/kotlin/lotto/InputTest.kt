package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class InputTest : NsTest() {
    @Test
    fun `입력된 값이 숫자 외의 것이 들어왔을 경우 예외 상황`() {
        assertSimpleTest {
            runException("1000j")
            assertThat(output()).contains("숫자만 입력할 수 있습니다")
        }
    }

    @Test
    fun `입력된 값이 공백인 경우 예외 상황`() {
        assertSimpleTest {
            runException("  ")
            assertThat(output()).contains("값을 입력해 주세요")
        }
    }

    @Test
    fun `입력된 값이 1000의 배수가 아닌 경우 예외 상황`() {
        assertSimpleTest {
            runException("1500")
            assertThat(output()).contains("1000원 단위로 입려해주십시오")
        }

    }


    override fun runMain() {
        main()
    }


}