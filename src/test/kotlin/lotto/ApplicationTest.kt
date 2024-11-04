package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
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

    @Nested
    @DisplayName("예외 테스트")
    inner class InvalidInputTests {
        @Test
        fun `예외 테스트`() {
            assertSimpleTest {
                runException("1000j")
                assertThat(output()).contains(ERROR_MESSAGE)
            }
        }

        @Test
        fun `잘못된 금액 입력 시 예외 처리`() {
            assertSimpleTest {
                runException("1234")
                assertThat(output()).contains(ERROR_MESSAGE)
            }
        }

        @Test
        fun `0원 입력 시 예외 처리`() {
            assertSimpleTest {
                runException("0")
                assertThat(output()).contains(ERROR_MESSAGE)
            }
        }

        @Test
        fun `숫자가 아닌 문자 입력 시 예외 처리`() {
            assertSimpleTest {
                runException("abc")
                assertThat(output()).contains(ERROR_MESSAGE)
            }
        }

        @Test
        fun `빈 칸 입력 시 예외 처리`() {
            assertSimpleTest {
                runException("\n")
                assertThat(output()).contains(ERROR_MESSAGE)
            }
        }

        @Test
        fun `로또 숫자가 총 6개가 아닌 경우 예외 처리`() {
            assertSimpleTest {
                runException("5000", "1,2,3,4,5");
                assertThat(output()).contains(ERROR_MESSAGE)
            }
        }

        @Test
        fun `로또 숫자가 중복되는 경우 예외 처리`() {
            assertSimpleTest {
                runException("5000", "1,2,3,4,5,5");
                assertThat(output()).contains(ERROR_MESSAGE)
            }
        }


        @Test
        fun `로또 숫자가 1~45 범위를 벗어나는 경우 예외 처리`() {
            assertSimpleTest {
                runException("5000", "1,2,3,4,5,46");
                assertThat(output()).contains(ERROR_MESSAGE)
            }
        }

        @Test
        fun `로또 숫자가 숫자가 아닌 경우 예외 처리`() {
            assertSimpleTest {
                runException("5000", "1,2,3,4,5,a");
                assertThat(output()).contains(ERROR_MESSAGE)
            }
        }
        @Test
        fun `로또 숫자가 빈칸인 경우 예외 처리`() {
            assertSimpleTest {
                runException("5000", "1,2,3,4,5,");
                assertThat(output()).contains(ERROR_MESSAGE)
            }
        }


        @Test
        fun `보너스 번호가 총 1개가 아닌 경우 예외 처리`() {
            assertSimpleTest {
                runException("5000", "1,2,3,4,5,6", "1,2");
                assertThat(output()).contains(ERROR_MESSAGE)
            }
        }
        @Test
        fun `보너스 번호가 빈칸인 경우 예외 처리`() {
            assertSimpleTest {
                runException("5000", "1,2,3,4,5,6", "\n");
                assertThat(output()).contains(ERROR_MESSAGE)
            }
        }

        @Test
        fun `보너스 번호가 숫자가 아닌 경우 예외 처리`() {
            assertSimpleTest {
                runException("5000", "1,2,3,4,5,6", "a");
                assertThat(output()).contains(ERROR_MESSAGE)
            }
        }

        @Test
        fun `보너스 번호가 1~45 범위를 벗어나는 경우 예외 처리`() {
            assertSimpleTest {
                runException("5000", "1,2,3,4,5,6", "46");
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
