package lotto.input

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import lotto.utils.ValidationUtils
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputWinningNumberValidationTest : NsTest() {

    @Test
    fun `예외 테스트-당첨번호가 "숫자,"가 아닌 다른 문자열이 섞여 있을 때`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1,2,3,7,선미,샌디") }
        }
    }

    @Test
    fun `예외 테스트-당첨번호의 개수가 6개가 아닐 때`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1,2,3,4,5") }
        }
    }

    @Test
    fun `예외 테스트-당첨번호에 1~45 사이가 아닌 정수가 있을 때`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1,2,3,4,5,100") }
        }
    }

    @Test
    fun `예외 테스트-당첨번호에 중복된 숫자가 있을 때`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("20000000") }
        }
    }

    override fun runMain() {
        val number = Console.readLine()
        ValidationUtils.checkValidWinningNumbers(number, ",")
        Console.close()
    }
}