package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoRankTest {
    @Test
    fun `6개 번호가 일치하면 FIRST`() {
        val rank = LottoRank.getRank(matchCount = 6, matchBonus = false)
        assertThat(rank).isEqualTo(LottoRank.FIRST)
    }
    @Test
    fun `5개 번호가 일치하면 SECOND`() {
        val rank = LottoRank.getRank(matchCount = 5, matchBonus = false)
        assertThat(rank).isEqualTo(LottoRank.SECOND)
    }
    @Test
    fun `5개 번호와 보너스번호 일치하면 THIRD`() {
        val rank = LottoRank.getRank(matchCount = 6, matchBonus = true)
        assertThat(rank).isEqualTo(LottoRank.THIRD)
    }
    @Test
    fun `4개 번호가 일치하면 FOURTH`() {
        val rank = LottoRank.getRank(matchCount = 6, matchBonus = false)
        assertThat(rank).isEqualTo(LottoRank.FOURTH)
    }
    @Test
    fun `3개 번호가 일치하면 FIRST`() {
        val rank = LottoRank.getRank(matchCount = 6, matchBonus = false)
        assertThat(rank).isEqualTo(LottoRank.FIFTH)
    }
    @Test
    fun `2개 이하의 번호가 일치하면 NONE`() {
        val rank = LottoRank.getRank(matchCount = 2, matchBonus = false)
        assertThat(rank).isEqualTo(LottoRank.NONE)
    }

}