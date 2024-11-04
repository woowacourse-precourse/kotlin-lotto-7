package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ApplicationTest : NsTest() {

    @Nested
    @DisplayName("기능 테스트")
    inner class FunctionalTest {
        @Test
        fun `정상 동작 테스트`() {
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
        fun `최대 수익률 테스트`() {
            assertRandomUniqueNumbersInRangeTest(
                {
                    run("1000", "1,2,3,4,5,6", "7")
                    assertThat(output()).contains(
                        "1개를 구매했습니다.",
                        "[1, 2, 3, 4, 5, 6]",
                        "3개 일치 (5,000원) - 0개",
                        "4개 일치 (50,000원) - 0개",
                        "5개 일치 (1,500,000원) - 0개",
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                        "6개 일치 (2,000,000,000원) - 1개",
                        "총 수익률은 200,000,000.0%입니다."
                    )
                },
                listOf(1, 2, 3, 4, 5, 6),
            )
        }
    }

    @Nested
    @DisplayName("예외 테스트")
    inner class ExceptionTest {
        @ParameterizedTest
        @ValueSource(strings = ["100", "0", "-1000", "1000j", "1000.0"])
        fun `잘못된 금액 입력 시 오류가 발생한다`(price: String) {
            assertSimpleTest {
                runException(price)
                assertThat(output()).contains(ERROR_MESSAGE)
            }
        }

        @ParameterizedTest
        @ValueSource(strings = ["1.2.3.4.5.6", "123456", "-1,2,3,4,5,6", "1,2,3,4,5,5", "1,2,3,4,5", "1,2,3,4,5,6,7", "1,2,3,4,5,46"])
        fun `잘못된 당첨 숫자 입력 시 오류가 발생한다`(winningNumber: String) {
            assertSimpleTest {
                runException("1000", winningNumber)
                assertThat(output()).contains(ERROR_MESSAGE)
            }
        }

        @ParameterizedTest
        @ValueSource(strings = ["-1", "0", "46", "aa"])
        fun `잘못된 보너스 숫자 입력 시 오류가 발생한다`(bonusNumber: String) {
            assertSimpleTest {
                runException("1000", "1,2,3,4,5,6", bonusNumber)
                assertThat(output()).contains(ERROR_MESSAGE)
            }
        }
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val ERROR_MESSAGE: String = "[ERROR]"
    }
}
