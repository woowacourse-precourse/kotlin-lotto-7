package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class LottoGameTest : NsTest() {
    @Nested
    @DisplayName("예외 상황 테스트")
    inner class ExceptionScenarios {
        @Test
        fun `잘못된 금액 입력`() {
            assertSimpleTest {
                runException("1000j")
                assertThat(output()).contains("[ERROR]")
            }
        }

        @Test
        fun `1000원 단위가 아닌 금액 입력`() {
            assertSimpleTest {
                runException("1500")
                assertThat(output()).contains("[ERROR]")
            }
        }

        @Test
        fun `잘못된 당첨 번호 입력`() {
            assertSimpleTest {
                runException("1000", "1,2,3,4,5")
                assertThat(output()).contains("[ERROR]")
            }
        }

        @Test
        fun `범위를 벗어난 당첨 번호 입력`() {
            assertSimpleTest {
                runException("1000", "1,2,3,4,5,46", "6")
                assertThat(output()).contains("[ERROR]")
            }
        }

        @Test
        fun `중복된 당첨 번호 입력`() {
            assertSimpleTest {
                runException("10000", "1,2,3,4,5,5", "6")
                assertThat(output()).contains("[ERROR]")
            }
        }

        @Test
        fun `범위를 벗어난 보너스 번호 입력`() {
            assertSimpleTest {
                runException("10000", "1,2,3,4,5,6", "46")
                assertThat(output()).contains("[ERROR]")
            }
        }

        @Test
        fun `당첨 번호와 중복된 보너스 번호 입력`() {
            assertSimpleTest {
                runException("1000", "1,2,3,4,5,6", "6")
                assertThat(output()).contains("[ERROR]")
            }
        }
    }

    @Test
    @DisplayName("수익률 계산 테스트")
    fun profitRateTest() {
        assertRandomUniqueNumbersInRangeTest(
            {
                run("8000", "1,2,3,4,5,6", "7")
                assertThat(output()).contains("총 수익률은 62.5%입니다.")
            },
            listOf(8, 21, 23, 41, 42, 43),
            listOf(3, 5, 11, 16, 32, 38),
            listOf(7, 11, 16, 35, 36, 44),
            listOf(1, 8, 11, 31, 41, 42),
            listOf(13, 14, 16, 38, 42, 45),
            listOf(7, 11, 30, 40, 42, 43),
            listOf(2, 13, 22, 32, 38, 45),
            listOf(1, 3, 5, 14, 22, 45),
        )
    }

    override fun runMain() {
        main()
    }
}
