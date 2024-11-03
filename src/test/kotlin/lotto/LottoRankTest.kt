package lotto

import lotto.model.LottoRank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoRankTest {

    @ParameterizedTest
    @CsvSource(
        "3, false",
        "4, false",
        "5, false",
        "5, true",
        "6, false")
    fun `로또 당첨 번호 매칭 테스트`(rank: Int, bonus: Boolean) {
        assertDoesNotThrow { LottoRank.getRank(rank, bonus) }
    }

    @ParameterizedTest
    @CsvSource(
        "2, false",
        "7, false")
    fun `매칭된 개수가 맞지 않을 경우 테스트`(rank: Int, bonus: Boolean) {
        val result = LottoRank.getRank(rank, bonus)
        assertThat(result).isEqualTo(LottoRank.NONE)
    }

    @Test
    fun `보너스 번호가 필요하지 않은 경우 당첨 테스트`() {
        val fifthResult = LottoRank.getRank(3, true)
        val fourthResult = LottoRank.getRank(4, true)
        val firstResult = LottoRank.getRank(6, true)

        assertThat(fifthResult).isEqualTo(LottoRank.FIFTH)
        assertThat(fourthResult).isEqualTo(LottoRank.FOURTH)
        assertThat(firstResult).isEqualTo(LottoRank.FIRST)
    }
}