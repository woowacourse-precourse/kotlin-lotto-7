package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FunctionalTest : NsTest() {
    @Test
    fun `기능 테스트(1)`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                run("1000", "1,2,3,4,5,6", "7")
                assertThat(output()).contains(
                    "1개를 구매했습니다.",
                    "[1, 2, 3, 41, 42, 43]",
                    "3개 일치 (5,000원) - 1개",
                    "4개 일치 (50,000원) - 0개",
                    "5개 일치 (1,500,000원) - 0개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                    "6개 일치 (2,000,000,000원) - 0개",
                    "총 수익률은 500.0%입니다."
                )
            },
            listOf(1, 2, 3, 41, 42, 43),
        )
    }

    @Test
    fun `기능 테스트(2)`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                run("1000", "1,2,3,4,5,6", "7")
                assertThat(output()).contains(
                    "1개를 구매했습니다.",
                    "[1, 2, 3, 4, 42, 43]",
                    "3개 일치 (5,000원) - 0개",
                    "4개 일치 (50,000원) - 1개",
                    "5개 일치 (1,500,000원) - 0개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                    "6개 일치 (2,000,000,000원) - 0개",
                    "총 수익률은 5000.0%입니다."
                )
            },
            listOf(1, 2, 3, 4, 42, 43),
        )
    }

    @Test
    fun `기능 테스트(3)`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                run("1000", "1,2,3,4,5,6", "7")
                assertThat(output()).contains(
                    "1개를 구매했습니다.",
                    "[1, 2, 3, 4, 5, 43]",
                    "3개 일치 (5,000원) - 0개",
                    "4개 일치 (50,000원) - 0개",
                    "5개 일치 (1,500,000원) - 1개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                    "6개 일치 (2,000,000,000원) - 0개",
                    "총 수익률은 150000.0%입니다."
                )
            },
            listOf(1, 2, 3, 4, 5, 43),
        )
    }

    @Test
    fun `기능 테스트(4)`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                run("1000", "1,2,3,4,5,6", "7")
                assertThat(output()).contains(
                    "1개를 구매했습니다.",
                    "[1, 2, 3, 4, 5, 7]",
                    "3개 일치 (5,000원) - 0개",
                    "4개 일치 (50,000원) - 0개",
                    "5개 일치 (1,500,000원) - 0개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                    "6개 일치 (2,000,000,000원) - 0개",
                    "총 수익률은 3000000.0%입니다."
                )
            },
            listOf(1, 2, 3, 4, 5, 7),
        )
    }

    @Test
    fun `기능 테스트(5)`() {
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
                    "총 수익률은 200000000.0%입니다."
                )
            },
            listOf(1, 2, 3, 4, 5, 6),
        )
    }

    override fun runMain() {
        main()
    }
}