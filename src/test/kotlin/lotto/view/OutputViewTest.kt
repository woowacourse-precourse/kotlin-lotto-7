package lotto.view

import lotto.model.LottoRank
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class OutputViewTest {
    private val standardOut = System.out
    private val outputStreamCaptor = ByteArrayOutputStream()

    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(outputStreamCaptor))
    }

    @AfterEach
    fun tearDown() {
        System.setOut(standardOut)
    }

    @Test
    fun `로또 정보 출력 테스트`() {
        // 테스트 데이터
        val lottoNumbers = listOf(
            listOf(1, 2, 3, 4, 5, 6),
            listOf(7, 8, 9, 10, 11, 12)
        )

        // 메서드 호출
        OutputView.printLottoNumbers(lottoNumbers)

        // 기대되는 출력
        val expectedOutput = """
            2개를 구매했습니다.
            [1, 2, 3, 4, 5, 6]
            [7, 8, 9, 10, 11, 12]
        """.trimIndent()

        // 출력 결과 비교
        assertEquals(expectedOutput, outputStreamCaptor.toString().trim())
    }

    @Test
    fun `로또 결과 출력 테스트`() {
        // 테스트 데이터
        val result = mutableMapOf(
            LottoRank.FIRST to 1,
            LottoRank.SECOND to 0,
            LottoRank.THIRD to 2,
            LottoRank.FOURTH to 3,
            LottoRank.FIFTH to 4,
            LottoRank.NONE to 0
        )

        // 메서드 호출
        OutputView.printLottoResult(result)

        // 기대되는 출력
        val expectedOutput = """
            당첨 통계
            ---------
            3개 일치 (5,000원) - 4개
            4개 일치 (50,000원) - 3개
            5개 일치 (1,500,000원) - 2개
            5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
            6개 일치 (2,000,000,000원) - 1개
        """.trimIndent()

        // 출력 결과 비교
        assertEquals(expectedOutput, outputStreamCaptor.toString().trim())
    }

    @Test
    fun `수익률 출력 테스트`() {
        // 테스트 데이터
        val profitRate = 123.45

        // 메서드 호출
        OutputView.printProfitRate(profitRate)

        // 기대되는 출력
        val expectedOutput = "총 수익률은 123.5%입니다."

        // 출력 결과 비교
        assertEquals(expectedOutput, outputStreamCaptor.toString().trim())
    }
}