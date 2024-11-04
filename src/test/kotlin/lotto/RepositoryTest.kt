package lotto

import lotto.domain.Lotto
import lotto.repository.Repository
import lotto.domain.Result
import lotto.domain.WinningRank
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class RepositoryTest {
    private lateinit var repository: Repository
    private lateinit var result: Result

    @BeforeEach
    fun setup() {
        repository = Repository()
        result = Result()
        repository.result = result

        repository.lottos = mutableListOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(1, 2, 3, 7, 8, 9)),
            Lotto(listOf(1, 2, 3, 4, 5, 9))
        )
        repository.setPurchaseAmount(3000)
        repository.setWinningNumber(listOf(1, 2, 3, 4, 5, 6))
        repository.setBonusNumber(7) // 예시 보너스 번호
    }

    @Test
    fun `등수별 상금을 올바르게 계산한다`() {
        repository.winLottery()

        val expectedTotalPrice = (1 * WinningRank.THREE_MATCH.prize) +
                (1 * WinningRank.FIVE_MATCH.prize) +
                (1 * WinningRank.SIX_MATCH.prize)

        val expectedProfitRate = (expectedTotalPrice.toDouble() / 3000) * 100

        assertEquals(expectedTotalPrice, result.totalPrice)
        assertEquals(expectedProfitRate, result.totalProfit)
    }
}