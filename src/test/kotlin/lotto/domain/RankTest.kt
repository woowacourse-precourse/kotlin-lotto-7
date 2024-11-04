package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class RankTest {

    @ParameterizedTest
    @CsvSource(
        "6, false, FIRST, 2000000000",
        "5, true, SECOND, 30000000",
        "5, false, THIRD, 1500000",
        "4, false, FOURTH, 50000",
        "3, false, FIFTH, 5000",
        "2, false, NONE, 0",
        "1, false, NONE, 0",
        "0, false, NONE, 0"
    )
    @DisplayName("매칭 개수와 보너스 번호의 일치 여부에 따라 등수를 결정한다")
    fun rankTest(matchCount: Int, bonusMatch: Boolean, expectedRank: Rank, expectedPrize: Int) {
        // when
        val rank = Rank.findByMatch(matchCount, bonusMatch)

        // then
        assertThat(rank).isEqualTo(expectedRank)
        assertThat(rank.getPrize()).isEqualTo(expectedPrize)
    }

}
