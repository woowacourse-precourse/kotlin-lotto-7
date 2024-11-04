package lotto

import lotto.domain.usecase.CalculateLottoReturnUseCase
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class CalculateLottoReturnUseCaseTest {
    private val calculateLottoReturnUseCase = CalculateLottoReturnUseCase()

    @ParameterizedTest
    @CsvSource(
        "2000000000, 200000000.0%",
        "30000000, 3000000.0%",
        "1500000, 150000.0%",
        "50000, 5000.0%",
        "5000, 500.0%",
        "0, 0.0%"
    )
    fun `1등에서 5등 그리고 당첨 되지 않은 상금까지 단일 상금 수익률 계산 테스트`(
        winningPrize: Int,
        expectedRate: String
    ) {
        val result = calculateLottoReturnUseCase.execute(listOf(winningPrize), 1_000)
        assertEquals(result, expectedRate)
    }

    @Test
    fun `1등과 4등 당첨 수익률 계산 테스트`() {
        val result = calculateLottoReturnUseCase.execute(listOf(2_000_000_000, 50_000), 2_000)
        val expect = "100002500.0%"
        assertEquals(result, expect)
    }

    @DisplayName("소수점 두 번째 자리에서 반올림하여 올림되는 경우 (5,000원 당첨, 9,000원 지출 -> 55.555..% -> 55.6%)")
    @Test
    fun `소수점 두번째 반올림으로 올림하는 계산 테스트`() {
        val result = calculateLottoReturnUseCase.execute(listOf(5000, 0, 0, 0, 0, 0, 0, 0, 0), 9000)
        val expect = "55.6%"
        assertEquals(result, expect)
    }

    @DisplayName("소수점 두 번째 자리에서 반올림하여 내림되는 경우 (5,000원 당첨, 6,000원 지출 -> 83.333..% -> 83.3)")
    @Test
    fun `소수점 두번째 반올림으로 내림하는 계산 테스트`() {
        val result = calculateLottoReturnUseCase.execute(listOf(5000, 0, 0, 0, 0, 0), 6000)
        val expect = "83.3%"
        assertEquals(result, expect)
    }
}