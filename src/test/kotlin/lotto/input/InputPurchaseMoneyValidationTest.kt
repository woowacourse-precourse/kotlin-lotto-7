package lotto.input

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import lotto.utils.ValidationUtils
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputPurchaseMoneyValidationTest : NsTest() {

    @Test
    fun `예외 테스트-구입금액이 숫자가 아닌 다른 문자열이 섞여 있을 때`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1000원") }
        }
    }

    @Test
    fun `예외 테스트-구입금액이 양수가 아닐 때`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("0") }
        }
    }

    @Test
    fun `예외 테스트-구입금액이 1000단위가 아닐 때`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("123456") }
        }
    }

    @Test
    fun `예외 테스트-구입금액이 100만원 초과일 때`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("20000000") }
        }
    }

    override fun runMain() {
        val money = Console.readLine()
        ValidationUtils.checkValidInputPurchaseMoney(money)
        Console.close()
    }
}