package lotto.domain.rank

import lotto.dto.MatchedInfoDto
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LottoRankTest {


    @ParameterizedTest
    @MethodSource("provideDtoForGetRankMethod")
    fun `getRank()는 맞춘 개수에 따라 올바른 등수를 반환한다`(input: MatchedInfoDto, expected: LottoRank) {
        assertEquals(expected, LottoRank.getRank(input))
    }

    private fun provideDtoForGetRankMethod(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(MatchedInfoDto(6, false), LottoRank.FIRST),
            Arguments.of(MatchedInfoDto(5, true), LottoRank.SECOND),
            Arguments.of(MatchedInfoDto(5, false), LottoRank.THIRD),
            Arguments.of(MatchedInfoDto(4, true), LottoRank.FOURTH),
            Arguments.of(MatchedInfoDto(3, false), LottoRank.FIFTH),
            Arguments.of(MatchedInfoDto(2, true), LottoRank.NONE),
        )
    }
}

