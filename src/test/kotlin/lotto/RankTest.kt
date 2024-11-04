package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import lotto.model.Rank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RankTest {

    @Test
    fun `1등 테스트`() {
        assertSimpleTest {
            val rank = Rank.matchRank(6, false)
            assertThat(rank).isEqualTo(Rank.FIRST)
        }
    }

    @Test
    fun `2등 테스트`() {
        assertSimpleTest {
            val rank = Rank.matchRank(5, true)
            assertThat(rank).isEqualTo(Rank.SECOND)
        }
    }

    @Test
    fun `3등 테스트`() {
        assertSimpleTest {
            val rank = Rank.matchRank(5, false)
            assertThat(rank).isEqualTo(Rank.THIRD)
        }
    }

    @Test
    fun `4등 테스트`() {
        assertSimpleTest {
            val rank = Rank.matchRank(4, false)
            assertThat(rank).isEqualTo(Rank.FOURTH)
        }
    }

    @Test
    fun `5등 테스트`() {
        assertSimpleTest {
            val rank = Rank.matchRank(3, false)
            assertThat(rank).isEqualTo(Rank.FIFTH)
        }
    }

    @Test
    fun `낙첨 테스트`() {
        assertSimpleTest {
            val rank = Rank.matchRank(0, false)
            assertThat(rank).isEqualTo(Rank.NONE)
        }
    }
}