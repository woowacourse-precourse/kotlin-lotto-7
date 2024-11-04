package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoResultTest {

    private val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
    private val bonusNumber = 7

    @Test
    fun `올바르게 당첨 통계 결과를 계산한다`() {
        // given
        val lottos = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(1, 2, 3, 4, 5, 7)),
            Lotto(listOf(1, 2, 3, 4, 5, 8)),
            Lotto(listOf(1, 2, 3, 4, 8, 9)),
            Lotto(listOf(1, 2, 3, 8, 9, 10)),
            Lotto(listOf(1, 2, 8, 9, 10, 11))
        )

        // when
        val lottoResult = LottoResult(lottos, winningNumbers, bonusNumber)
        val rankCount = lottoResult.getRankCount()

        // then
        assertThat(rankCount[Rank.FIRST]).isEqualTo(1)
        assertThat(rankCount[Rank.SECOND]).isEqualTo(1)
        assertThat(rankCount[Rank.THIRD]).isEqualTo(1)
        assertThat(rankCount[Rank.FOURTH]).isEqualTo(1)
        assertThat(rankCount[Rank.FIFTH]).isEqualTo(1)
        assertThat(rankCount[Rank.NONE]).isEqualTo(1)
    }

    @Test
    fun `올바륵 총 당첨금을 계산한다`() {
        // given
        val lottos = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(1, 2, 3, 4, 5, 7)),
            Lotto(listOf(1, 2, 3, 4, 5, 8))
        )

        // when
        val lottoResult = LottoResult(lottos, winningNumbers, bonusNumber)
        val totalPrize = lottoResult.getTotalPrize()

        // then
        val expectedPrize = 2_000_000_000L + 30_000_000L + 1_500_000L
        assertThat(totalPrize).isEqualTo(expectedPrize)
    }

    @Test
    fun `당첨 번호가 없는 경우 모두 낙첨으로 처리한다`() {
        // given
        val lottos = listOf(
            Lotto(listOf(11, 12, 13, 14, 15, 16)),
            Lotto(listOf(21, 22, 23, 24, 25, 26))
        )

        // when
        val lottoResult = LottoResult(lottos, winningNumbers, bonusNumber)
        val rankCount = lottoResult.getRankCount()

        // then
        assertThat(rankCount[Rank.NONE]).isEqualTo(2)
        assertThat(lottoResult.getTotalPrize()).isZero()
    }

    @Test
    fun `보너스 번호 일치 여부에 따라 2등과 3등이 구분된다`() {
        // given
        val lottos = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 7)),
            Lotto(listOf(1, 2, 3, 4, 5, 8))
        )

        // when
        val lottoResult = LottoResult(lottos, winningNumbers, bonusNumber)
        val rankCount = lottoResult.getRankCount()

        // then
        assertThat(rankCount[Rank.SECOND]).isEqualTo(1)
        assertThat(rankCount[Rank.THIRD]).isEqualTo(1)
    }
}
