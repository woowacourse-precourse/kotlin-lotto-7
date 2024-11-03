package lotto

import lotto.domain.usecase.CalculateLottoReturnUseCase
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CalculateLottoReturnUseCaseTest {
    private val calculateLottoReturnUseCase = CalculateLottoReturnUseCase()

    @Test
    fun `1등 당첨 수익률 계산 테스트`() {
        val result = calculateLottoReturnUseCase.execute(listOf(2_000_000_000), 1_000)
        val expect = "200000000.0%"
        assertEquals(result, expect)
    }

    @Test
    fun `2등 당첨 수익률 계산 테스트`() {
        val result = calculateLottoReturnUseCase.execute(listOf(30_000_000), 1_000)
        val expect = "3000000.0%"
        assertEquals(result, expect)
    }

    @Test
    fun `3등 당첨 수익률 계산 테스트`() {
        val result = calculateLottoReturnUseCase.execute(listOf(1_500_000), 1_000)
        val expect = "150000.0%"
        assertEquals(result, expect)
    }

    @Test
    fun `4등 당첨 수익률 계산 테스트`() {
        val result = calculateLottoReturnUseCase.execute(listOf(50_000), 1_000)
        val expect = "5000.0%"
        assertEquals(result, expect)
    }

    @Test
    fun `5등 당첨 수익률 계산 테스트`() {
        val result = calculateLottoReturnUseCase.execute(listOf(5_000), 1_000)
        val expect = "500.0%"
        assertEquals(result, expect)
    }

    @Test
    fun `6등 당첨 수익률 계산 테스트`() {
        val result = calculateLottoReturnUseCase.execute(listOf(0), 1_000)
        val expect = "0.0%"
        assertEquals(result, expect)
    }

    @Test
    fun `1등과 4등 당첨 수익률 계산 테스트`() {
        val result = calculateLottoReturnUseCase.execute(listOf(2_000_000_000,50_000), 2_000)
        val expect = "100002500.0%"
        assertEquals(result, expect)
    }

    @DisplayName("56.5555... 반올림 테스트")
    @Test
    fun `소수점 두번째 반올림으로 올림하는 계산 테스트`(){
        val result = calculateLottoReturnUseCase.execute(listOf(5000,0,0,0,0,0,0,0,0), 9000)
        val expect = "55.6%"
        assertEquals(result, expect)
    }

    @DisplayName("83.333... 반올림 테스트")
    @Test
    fun `소수점 두번째 반올림으로 내림하는 계산 테스트`(){
        val result = calculateLottoReturnUseCase.execute(listOf(5000,0,0,0,0,0), 6000)
        val expect = "83.3%"
        assertEquals(result, expect)
    }
}