package lotto.input

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.test.NsTest
import lotto.constants.ErrorMessage
import lotto.utils.ValidationUtils
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputBonusNumberValidationTest : NsTest() {

    @Test
    fun `예외 테스트-보너스번호가 1~45의 정수가 아닌 다른 문자열이 섞여 있을 때`() {
        val exception = assertThrows<IllegalArgumentException> {
            runException("10번")
        }
        assertEquals(ErrorMessage.BONUS_NUMBER_INVALID_FORMAT, exception.message)
    }

    @Test
    fun `예외 테스트-보너스번호에 공백이 포함되어 있을 때`() {
        val exception = assertThrows<IllegalArgumentException> {
            runException("10 ")
        }
        assertEquals(ErrorMessage.BONUS_NUMBER_INVALID_FORMAT, exception.message)
    }

    @Test
    fun `예외 테스트-보너스번호가 1~45의 정수가 아닐 때`() {
        val exception = assertThrows<IllegalArgumentException> {
            runException("100")
        }
        assertEquals(ErrorMessage.BONUS_NUMBER_NOT_IN_RANGE, exception.message)
    }

    @Test
    fun `예외 테스트-보너스번호가 당첨번호와 중복될 때`() {
        val exception = assertThrows<IllegalArgumentException> {
            runException("1")
        }
        assertEquals(ErrorMessage.BONUS_NUMBER_OVERLAP, exception.message)
    }

    override fun runMain() {
        val number = Console.readLine()
        ValidationUtils.checkValidBonusNumber(number, listOf(1,2,3,4,5,6))
        Console.close()
    }
}