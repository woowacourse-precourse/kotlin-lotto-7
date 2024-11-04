package lotto

import lotto.common.LottoRank
import lotto.domain.entity.BonusNumber
import lotto.domain.entity.Lotto
import lotto.domain.entity.WinningNumbers
import lotto.domain.usecase.CalculateLottoRankUseCase
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CalculateLottoRankUseCaseTest {
    private val calculateLottoRankUseCase = CalculateLottoRankUseCase()

    @Test
    fun `6개를 맞춰서 등수가 1등일 경우 테스트`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = BonusNumber(7, winningNumbers)
        val rank = calculateLottoRankUseCase.execute(lotto, winningNumbers, bonusNumber)
        val expect = LottoRank.FIRST
        assertEquals(expect, rank)
    }

    @Test
    fun `5개를 맞추고 보너스 번호를 맞춰서 등수가 2등일 경우 테스트`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 7))
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = BonusNumber(7, winningNumbers)
        val rank = calculateLottoRankUseCase.execute(lotto, winningNumbers, bonusNumber)
        val expect = LottoRank.SECOND
        assertEquals(expect, rank)
    }

    @Test
    fun `2개를 맞춰서 등수가 6등일 경우 테스트`() {
        val lotto = Lotto(listOf(1, 2, 8, 9, 10, 11))
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = BonusNumber(7, winningNumbers)
        val rank = calculateLottoRankUseCase.execute(lotto, winningNumbers, bonusNumber)
        val expect = LottoRank.NON
        assertEquals(expect, rank)
    }
}