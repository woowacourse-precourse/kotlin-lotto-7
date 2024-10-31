package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CalculateLottoReturnUseCaseTest {
    private val calculateLottoReturnUseCase = CalculateLottoReturnUseCase()

    @Test
    fun `총 수익률 계산 테스트`() {
        val result = calculateLottoReturnUseCase.execute(listOf(5000, 0, 0, 0, 0, 0, 0), 7000)
        val expect = "71.4%"
        assertEquals(result, expect)
    }
}