package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class RankTest {
    @Nested
    @DisplayName("당첨 등수 결정")
    inner class RankDetermination {
        @ParameterizedTest
        @CsvSource(
            "6,false,FIRST",
            "5,true,SECOND",
            "5,false,THIRD",
            "4,false,FOURTH",
            "3,false,FIFTH",
            "2,false,NONE",
        )
        fun `매칭 개수와 보너스 번호 일치 여부로 등수를 결정한다`(
            matchCount: Int,
            bonusMatch: Boolean,
            expectedRank: Rank,
        ) {
            assertThat(Rank.of(matchCount, bonusMatch)).isEqualTo(expectedRank)
        }
    }
}
