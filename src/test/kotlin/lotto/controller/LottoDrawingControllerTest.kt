package lotto.controller

import lotto.model.Lotto
import lotto.model.LottoMatchRank
import lotto.model.LottoTicket
import lotto.model.WinningStatistics
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LottoDrawingControllerTest {
    private lateinit var lottoTicket: LottoTicket
    private lateinit var winningStatistics: WinningStatistics
    private lateinit var lottoDrawingController: LottoDrawingController

    @BeforeEach
    fun setUp() {
        lottoTicket = LottoTicket().apply {
            userLottoNumbers = listOf(Lotto(listOf(1, 2, 3, 4, 5, 6)), Lotto(listOf(1, 2, 3, 4, 5, 7)))
        }
        winningStatistics = WinningStatistics()
        lottoDrawingController = LottoDrawingController(
            lottoTicket,
            listOf(1, 2, 3, 4, 5, 6),
            bonusNumber = 7,
            winningStatistics = winningStatistics
        )
    }

    @Test
    fun `calculateMatchCount는 로또 번호의 일치 개수를 계산해야 한다`() {
        lottoDrawingController.calculateMatchCount()

        assertThat(winningStatistics.matchCountStatistics[LottoMatchRank.FIFTH.ordinal]).isEqualTo(0)
        assertThat(winningStatistics.matchCountStatistics[LottoMatchRank.FOURTH.ordinal]).isEqualTo(0)
        assertThat(winningStatistics.matchCountStatistics[LottoMatchRank.THIRD.ordinal]).isEqualTo(0)
        assertThat(winningStatistics.matchCountStatistics[LottoMatchRank.SECOND.ordinal]).isEqualTo(1)
        assertThat(winningStatistics.matchCountStatistics[LottoMatchRank.FIRST.ordinal]).isEqualTo(1)
    }

    @Test
    fun `calculateTotalPrize는 총 상금을 계산해야 한다`() {
        lottoDrawingController.calculateMatchCount()
        lottoDrawingController.calculateTotalPrize()

        assertThat(winningStatistics.totalPrize).isEqualTo(
            winningStatistics.matchCountStatistics[LottoMatchRank.SECOND.ordinal] * LottoMatchRank.SECOND.prize +
                    winningStatistics.matchCountStatistics[LottoMatchRank.SECOND.ordinal] * LottoMatchRank.FIRST.prize
        )
    }

    @Test
    fun `calculateReturnRate는 구매 금액에 대한 수익률을 계산해야 한다`() {
        winningStatistics.addTotalPrize(3000)
        val purchaseAmount = 10000
        val returnRate = String.format("%.1f", lottoDrawingController.calculateReturnRate(purchaseAmount))

        assertThat(returnRate).isEqualTo("30.0")
    }
}