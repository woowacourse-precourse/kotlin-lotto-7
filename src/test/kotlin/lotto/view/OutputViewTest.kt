package lotto.view

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class OutputViewTest {

    @Test
    fun `로또 정보 출력 테스트`() {
        // 표준 출력을 캡처하기 위해 설정
        val outputStreamCaptor = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStreamCaptor))

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

        // 표준 출력을 원래대로 복원
        System.setOut(System.out)
    }
}