package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

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
    fun `예외 테스트 - 구입 금액이 Null인 경우`() {
        assertSimpleTest {
            runException(null)
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `예외 테스트 - 구입 금액이 Int가 아닌 경우`() {
        assertSimpleTest {
            runException("1000j")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `예외 테스트 - 구입 금액이 1000원 단위가 아닌 경우`() {
        assertSimpleTest {
            runException("1500")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `예외 테스트 - 당첨 번호 입력이 빈 경우`() {
        assertSimpleTest {
            runException("1000", "","6")  // 빈 문자열을 입력으로 제공
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }


    @Test
    fun `예외 테스트 - 당첨 번호가 1~45 사이가 아닌 경우`() {
        assertSimpleTest {
            runException("0,46,1,2,3,4")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `예외 테스트 - 당첨 번호 개수가 6개가 아닌 경우`() {
        assertSimpleTest {
            runException("1,2,3,4,5")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `예외 테스트 - 당첨 번호가 Int가 아닌 경우`() {
        assertSimpleTest {
            runException("1,2,3,4,5,a")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `예외 테스트 - 당첨 번호 중복된 경우`() {
        assertSimpleTest {
            runException("1,2,3,4,4,5")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `예외 테스트 - 보너스 번호 입력이 빈 경우`() {
        assertSimpleTest {
            runException("1,2,3,4,4,5","")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `예외 테스트 - 보너스 번호가 숫자가 아닌 경우`() {
        assertSimpleTest {
            runException("a")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `예외 테스트 - 보너스 번호가 1~45 사이가 아닌 경우`() {
        assertSimpleTest {
            runException("1,2,3,4,4,5","46") // 유효하지 않은 보너스 번호를 제공
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `예외 테스트 - 보너스 번호 중복된 경우`() {
        assertSimpleTest {
            runException("1,1")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `예외 테스트 - 보너스 번호가 Int가 아닌 경우`() {
        assertSimpleTest {
            runException("1,a")
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
