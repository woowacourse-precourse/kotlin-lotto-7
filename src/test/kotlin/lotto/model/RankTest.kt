package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RankTest {

    @Test
    fun `일치 개수와 보너스 번호에 따라 올바른 등급을 반환한다`() {
        assertThat(Rank.from(6, false)).isEqualTo(Rank.FIRST)
        assertThat(Rank.from(5, true)).isEqualTo(Rank.SECOND)
        assertThat(Rank.from(5, false)).isEqualTo(Rank.THIRD)
        assertThat(Rank.from(4, false)).isEqualTo(Rank.FOURTH)
        assertThat(Rank.from(3, false)).isEqualTo(Rank.FIFTH)
        assertThat(Rank.from(2, false)).isEqualTo(Rank.NONE)
    }

    @Test
    fun `상금이 올바르게 설정되어 있다`() {
        assertThat(Rank.FIRST.prize).isEqualTo(2_000_000_000)
        assertThat(Rank.SECOND.prize).isEqualTo(30_000_000)
        assertThat(Rank.THIRD.prize).isEqualTo(1_500_000)
        assertThat(Rank.FOURTH.prize).isEqualTo(50_000)
        assertThat(Rank.FIFTH.prize).isEqualTo(5_000)
        assertThat(Rank.NONE.prize).isEqualTo(0)
    }

    @Test
    fun `NONE 등급은 매칭이 없는 경우에 반환된다`() {
        val rank = Rank.from(0, false)
        assertThat(rank).isEqualTo(Rank.NONE)
    }

    @Test
    fun `일치 개수는 맞지만 보너스 여부가 다른 경우 올바른 등급이 반환된다`() {
        assertThat(Rank.from(5, true)).isNotEqualTo(Rank.THIRD)
        assertThat(Rank.from(5, false)).isNotEqualTo(Rank.SECOND)
    }
}
