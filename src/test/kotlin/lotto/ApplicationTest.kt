package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import javax.swing.JOptionPane.ERROR_MESSAGE

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
    fun `구입 금액 입력이 비어 있을 때 예외 발생`() {
        assertSimpleTest {
            runException("\n")
            assertThat(output()).contains(ERROR_MESSAGE, "구입 금액을 입력해야 합니다.")
        }
    }

    @Test
    fun `구입 금액이 숫자가 아닐 때 예외 발생`() {
        assertSimpleTest {
            runException("1000j")
            assertThat(output()).contains(ERROR_MESSAGE, "구입 금액은 숫자여야 합니다.")
        }
    }

    @Test
    fun `구입 금액이 음수일 때 예외 발생`() {
        assertSimpleTest {
            runException("-5000")
            assertThat(output()).contains(ERROR_MESSAGE, "구입 금액은 양수여야 합니다.")
        }
    }

    @Test
    fun `구입 금액이 1,000원 단위가 아닐 때 예외 발생`() {
        assertSimpleTest {
            runException("1500")
            assertThat(output()).contains(ERROR_MESSAGE, "구입 금액은 1,000원 단위여야 합니다.")
        }
    }

    @Test
    fun `당첨 번호 입력이 비어 있을 때 예외 발생`() {
        assertSimpleTest {
            runException("1000", "\n")
            assertThat(output()).contains(ERROR_MESSAGE, "당첨 번호를 입력해야 합니다.")
        }
    }

    @Test
    fun `당첨 번호의 개수가 6개가 아닐 때 예외 발생`() {
        assertSimpleTest {
            runException("1000", "1,2,3,4,5")
            assertThat(output()).contains(ERROR_MESSAGE, "당첨 번호는 6개를 입력해야 합니다.")
        }
    }

    @Test
    fun `당첨 번호가 1부터 45 사이가 아닐 때 예외 발생`() {
        assertSimpleTest {
            runException("1000", "1,2,3,4,5,46")
            assertThat(output()).contains(ERROR_MESSAGE, "당첨 번호는 1부터 45 사이의 숫자여야 합니다.")
        }
    }

    @Test
    fun `당첨 번호에 중복된 숫자가 있을 때 예외 발생`() {
        assertSimpleTest {
            runException("1000", "1,2,3,4,5,5")
            assertThat(output()).contains(ERROR_MESSAGE, "당첨 번호는 중복되지 않은 수로 이루어져야 합니다.")
        }
    }

    @Test
    fun `보너스 번호 입력이 비어 있을 때 예외 발생`() {
        assertSimpleTest {
            runException("1000", "1,2,3,4,5,6", "\n")
            assertThat(output()).contains(ERROR_MESSAGE, "보너스 번호를 입력해야 합니다.")
        }
    }

    @Test
    fun `보너스 번호가 숫자가 아닐 때 예외 발생`() {
        assertSimpleTest {
            runException("1000", "1,2,3,4,5,6", "abc")
            assertThat(output()).contains(ERROR_MESSAGE, "보너스 번호는 숫자여야 합니다.")
        }
    }

    @Test
    fun `보너스 번호가 1부터 45 사이가 아닐 때 예외 발생`() {
        assertSimpleTest {
            runException("1000", "1,2,3,4,5,6", "46")
            assertThat(output()).contains(ERROR_MESSAGE, "보너스 번호는 1부터 45 사이의 숫자여야 합니다.")
        }
    }

    @Test
    fun `보너스 번호가 당첨 번호와 중복될 때 예외 발생`() {
        assertSimpleTest {
            runException("1000", "1,2,3,4,5,6", "6")
            assertThat(output()).contains(ERROR_MESSAGE, "보너스 번호는 당첨 번호와 중복되지 않아야 합니다.")
        }
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val ERROR_MESSAGE: String = "[ERROR]"
    }
}
