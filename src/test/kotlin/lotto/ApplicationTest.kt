package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.setRemoveAssertJRelatedElementsFromStackTrace
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {
    @Test
    fun `기능 테스트`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                run("8000", "1,2,3,4,5,6", "7")
                assertThat(output()).contains(
                    "8개를 구매했습니다.",
                    "[8, 21, 23, 41, 42, 43]",
                    "[3, 5, 11, 16, 32, 38]",
                    "[7, 11, 16, 35, 36, 44]",
                    "[1, 8, 11, 31, 41, 42]",
                    "[13, 14, 16, 38, 42, 45]",
                    "[7, 11, 30, 40, 42, 43]",
                    "[2, 13, 22, 32, 38, 45]",
                    "[1, 3, 5, 14, 22, 45]",
                    "3개 일치 (5,000원) - 1개",
                    "4개 일치 (50,000원) - 0개",
                    "5개 일치 (1,500,000원) - 0개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                    "6개 일치 (2,000,000,000원) - 0개",
                    "총 수익률은 62.5%입니다."
                )
            },
            listOf(8, 21, 23, 41, 42, 43),
            listOf(3, 5, 11, 16, 32, 38),
            listOf(7, 11, 16, 35, 36, 44),
            listOf(1, 8, 11, 31, 41, 42),
            listOf(13, 14, 16, 38, 42, 45),
            listOf(7, 11, 30, 40, 42, 43),
            listOf(2, 13, 22, 32, 38, 45),
            listOf(1, 3, 5, 14, 22, 45)
        )
    }

    @Test
    fun `예외 테스트`() {
        assertSimpleTest {
            runException("1000j")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @DisplayName("잘못된 금액이 들어온 경우")
    @Test
    fun inputWrongMoney() {
        assertSimpleTest {
            // 숫자가 아닌 문자가 들어온 경우 (-, ., 그 외 모든 문자)
            runException(null)
            assertThat(output()).contains(ERROR_MESSAGE)

            runException("")
            assertThat(output()).contains(ERROR_MESSAGE)

            runException(" ")
            assertThat(output()).contains(ERROR_MESSAGE)

            runException("-1000")
            assertThat(output()).contains(ERROR_MESSAGE)

            runException("1000j")
            assertThat(output()).contains(ERROR_MESSAGE)

            // 1,000원으로 나누어 떨어지지 않는 경우
            runException("1001")
            assertThat(output()).contains(ERROR_MESSAGE)

            runException("900")
            assertThat(output()).contains(ERROR_MESSAGE)

            // 0이 입력된 경우
            runException("0")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @DisplayName("잘못된 당첨 번호가 들어온 경우")
    @Test
    fun inputWrongWinningNumber() {
        assertSimpleTest {
            // 잘못된 문자가 들어온 경우 (,나 공백 외의 문자)
            assertThrows<IllegalArgumentException> { runException("1000", null) }
            assertThrows<IllegalArgumentException> { runException("1000", "") }
            assertThrows<IllegalArgumentException> { runException("1000", " ") }
            assertThrows<IllegalArgumentException> { runException("1000", "1,-2,3,4,5,6") }
            assertThrows<IllegalArgumentException> { runException("1000", "1,-2,3,4,5,6") }

//            run("1000", "1,2,3,4,5, 6", "7") 공백을 포함한 문자열의 경우 어떻게 처리하는 것이 좋을까?

            // 6개의 숫자가 들어오지 않는 경우
            assertThrows<IllegalArgumentException> { runException("1000", "1,2,3,4,5,6,7") }
            assertThrows<IllegalArgumentException> { runException("1000", "1,2,3,4,5") }

            // 잘못된 숫자가 들어온 경(1~45 외의 수, 중복된 수, etc...)
            assertThrows<IllegalArgumentException> { runException("1000", "0,2,3,4,5,6") }
            assertThrows<IllegalArgumentException> { runException("1000", "1,2,3,4,5,46") }
            assertThrows<IllegalArgumentException> { runException("1000", "1,2,3,4,5,5") }
        }
    }

    @DisplayName("잘못된 보너스 번호가 입력된 경우")
    @Test
    fun inputWrongBonusNumber() {
        assertSimpleTest {
            // 숫자 외의 문자가 들어온 경우
            assertThrows<IllegalArgumentException> { runException("1000", "1,2,3,4,5,6", null) }
            assertThrows<IllegalArgumentException> { runException("1000", "1,2,3,4,5,6", "") }
            assertThrows<IllegalArgumentException> { runException("1000", "1,2,3,4,5,6", " ") }
            assertThrows<IllegalArgumentException> { runException("1000", "1,2,3,4,5,6", "7,") }

            // 잘못된 숫자가 들어온 경우 (1~45 외의 수, 당첨번호와 중복된 수, etc...)
            assertThrows<IllegalArgumentException> { runException("1000", "1,2,3,4,5,6", "77") }
            assertThrows<IllegalArgumentException> { runException("1000", "1,2,3,4,5,6", "6") }
        }
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val ERROR_MESSAGE: String = "[ERROR]"
    }
}
