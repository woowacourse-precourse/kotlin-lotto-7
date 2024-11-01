package lotto.unitTest

import lotto.domain.GameService
import lotto.model.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import lotto.model.WinningCounter.WinningCategory.*

class GameServiceTest {
    private lateinit var gameService: GameService

    @BeforeEach
    fun setUp() {
        gameService = GameService()
    }

    @Test
    fun buyLottosTest() {
        // given
        val lottoAmount = TEST_MONEY / GameService.ONE_LOTTO_PRICE

        // when
        val lottos = gameService.buyLottos(TEST_MONEY.toLong())

        // then
        assertThat(lottos).hasSize(lottoAmount)
        lottos.forEach { lotto ->
            assertThat(lotto.numbers().distinct()).hasSize(6)
            assertThat(lotto.numbers()).allMatch { it in 1..45 }
        }
    }

    @Test
    fun countWinningsTest() {
        // given
        val boughtLottos = createTestLottos()
        val winLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        // when
        val countWinnings = gameService.countWinnings(boughtLottos, winLotto, 7)

        // then
        assertThat(countWinnings.totalPrizeSum()).isEqualTo(
            MATCH_SIX.prize + MATCH_FIVE_BONUS.prize + MATCH_FIVE.prize
        )
        assertThat(countWinnings.inOrderNumbers()).isEqualTo(listOf(0, 0, 1, 1, 1))
    }

    @Test
    fun calculateReturnRateTest() {
        // given
        val boughtLottos = createTestLottos()
        val winLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val countWinnings = gameService.countWinnings(boughtLottos, winLotto, 7)
        val spentMoney = boughtLottos.size * GameService.ONE_LOTTO_PRICE.toLong()

        // when
        val returnRate = gameService.calculateReturnRate(countWinnings, spentMoney)

        // then
        assertThat(returnRate).isEqualTo("67716666.7%") // (2,031,500,000/ 3,000) * 100
    }

    private fun createTestLottos(): List<Lotto> {
        return listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(1, 2, 3, 4, 5, 7)),
            Lotto(listOf(1, 2, 3, 4, 5, 45))
        )
    }

    companion object {
        private const val TEST_MONEY = 500_000
    }
}