package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class OutputTest : NsTest() {
    @Test
    fun `잘못 입력된 당첨 번호 상황(1) `() {
        assertSimpleTest {
            runException("1000", "1")
            assertThat(output()).contains("6개의 숫자를 입력하셔야 합니다")
        }
    }

    @Test
    fun `잘못 입력된 당첨 번호 상황(2) `() {
        assertSimpleTest {
            runException("1000", "1,")
            assertThat(output()).contains("6개의 숫자를 입력하셔야 합니다")
        }
    }

    @Test
    fun `잘못 입력된 당첨 번호 상황(3) `() {
        assertSimpleTest {
            runException("1000", "1,2")
            assertThat(output()).contains("6개의 숫자를 입력하셔야 합니다")
        }
    }

    @Test
    fun `잘못 입력된 당첨 번호 상황(4) `() {
        assertSimpleTest {
            runException("1000", "1,2,3,4,5,65")
            assertThat(output()).contains("1~45 숫자를 입력해주십시오")
        }
    }

    @Test
    fun `잘못 입력된 당첨 번호 상황(5) `() {
        assertSimpleTest {
            runException("1000", "1,2,3,4,5,ㅁ")
            assertThat(output()).contains("숫자만 입력할 수 있습니다")
        }
    }


    override fun runMain() {
        main()
    }


}