package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class LottoGameWholeTest : NsTest() {
    @Test
    @DisplayName("공백 라인을 포함한 전체 예제 입력 테스트")
    fun wholeExampleTest() {
        assertRandomUniqueNumbersInRangeTest(
            {
                // given
                run("8000", "1,2,3,4,5,6", "7")

                // then
                val expected = """
                구입금액을 입력해 주세요.

                8개를 구매했습니다.
                [8, 21, 23, 41, 42, 43] 
                [3, 5, 11, 16, 32, 38] 
                [7, 11, 16, 35, 36, 44] 
                [1, 8, 11, 31, 41, 42] 
                [13, 14, 16, 38, 42, 45] 
                [7, 11, 30, 40, 42, 43] 
                [2, 13, 22, 32, 38, 45] 
                [1, 3, 5, 14, 22, 45]

                당첨 번호를 입력해 주세요.

                보너스 번호를 입력해 주세요.

                당첨 통계
                ---
                3개 일치 (5,000원) - 1개
                4개 일치 (50,000원) - 0개
                5개 일치 (1,500,000원) - 0개
                5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
                6개 일치 (2,000,000,000원) - 0개
                총 수익률은 62.5%입니다.
                """.trimIndent()

                assertThat(output().normalize()).contains(expected.normalize())
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

    private fun String.normalize(): String {
        return this.replace("\r\n", "\n")
    }


    @ParameterizedTest
    @MethodSource("inputListsForExceptionTest")
    fun wholeExceptionTest(inputList: List<String>) {
        assertSimpleTest {
            runException(*inputList.toTypedArray())
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val ERROR_MESSAGE: String = "[ERROR]"

        @JvmStatic
        fun inputListsForExceptionTest() = listOf(
            listOf(" "),
            listOf("1000j"),
            listOf("1001"),
            listOf("-1000"),
            listOf("8000", "123456", "6"),
            listOf("8000", "1, 2, 3, 4, 5, 6", "7"),
            listOf("8000", "1,2,3,4,5,5", "6"),
            listOf("8000", "1,2,3,4,5,46", "6"),
            listOf("8000", "0,2,3,4,5,5", "6"),
            listOf("8000", " ", "6"),
            listOf("8000", "1,2,3,4,5,6", "1"),
            listOf("8000", "1,2,3,4,5,6", "46"),
            listOf("8000", "1,2,3,4,5,6", "0"),
            listOf("8000", "1,2,3,4,5,6", " "),
        )
    }
}
