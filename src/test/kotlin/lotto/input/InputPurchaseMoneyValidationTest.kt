package lotto.input

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.test.NsTest
import lotto.constants.ErrorMessage
import lotto.utils.ValidationUtils
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Assertions.assertEquals

class InputPurchaseMoneyValidationTest : NsTest() {

    @Test
    fun `예외 테스트-구입금액이 숫자가 아닌 다른 문자열이 섞여 있을 때`() {
        val exception = assertThrows<IllegalArgumentException> {
            runException("1000원")
        }
        assertEquals(ErrorMessage.PURCHASE_MONEY_INVALID_FORMAT, exception.message)
    }

    @Test
    fun `예외 테스트-구입금액이 1000원 미만일 때`() {
        val exception = assertThrows<IllegalArgumentException> {
            runException("0")
        }
        assertEquals(ErrorMessage.PURCHASE_MONEY_LESS_THAN_MINIMUM, exception.message)
    }

    @Test
    fun `예외 테스트-구입금액이 1000단위가 아닐 때`() {
        val exception = assertThrows<IllegalArgumentException> {
            runException("123456")
        }
        assertEquals(ErrorMessage.PURCHASE_MONEY_NOT_IN_1000_UNITS, exception.message)
    }

    @Test
    fun `예외 테스트-구입금액이 100만원 초과일 때`() {
        val exception = assertThrows<IllegalArgumentException> {
            runException("20000000")
        }
        assertEquals(ErrorMessage.PURCHASE_MONEY_EXCEEDS_MAXIMUM, exception.message)
    }

    override fun runMain() {
        val money = Console.readLine()
        ValidationUtils.checkValidInputPurchaseMoney(money)
        Console.close()
    }
}