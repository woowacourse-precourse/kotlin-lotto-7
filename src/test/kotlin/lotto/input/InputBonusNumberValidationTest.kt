package lotto.input

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import lotto.utils.InputManager
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputBonusNumberValidationTest : NsTest() {

    @Test
    fun `예외 테스트-보너스번호가 1~45의 정수가 아닌 다른 문자열이 섞여 있을 때`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("10번") }
        }
    }

    @Test
    fun `예외 테스트-보너스번호에 공백이 포함되어 있을 때`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("10 ") }
        }
    }

    @Test
    fun `예외 테스트-보너스번호가 1~45의 정수가 아닐 때`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("100") }
        }
    }

    @Test
    fun `예외 테스트-보너스번호가 당첨번호와 중복될 때`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1") }
        }
    }

    override fun runMain() {
        val winningNumber = listOf(1,2,3,4,5,6)
        InputManager.getBonusNumber(winningNumber)
    }
}