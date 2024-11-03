package lotto.domain.usecase

import lotto.domain.model.BonusNumber
import lotto.domain.model.Lotto
import lotto.domain.model.Prize
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MatchingLottoNumberTest {
    @Test
    fun `로또 티켓이 당첨 번호와 일치하는 경우 올바른 상을 반환해야 한다`() {
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = BonusNumber(7)
        val quickPickLottoTickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(1, 2, 3, 4, 5, 7)),
            Lotto(listOf(1, 2, 3, 4, 5, 8)),
            Lotto(listOf(1, 2, 3, 4, 10, 11)),
            Lotto(listOf(1, 2, 3, 12, 13, 14)),
            Lotto(listOf(20, 21, 22, 23, 24, 25))
        )
        val matchingLottoNumber = MatchingLottoNumber(winningLotto, bonusNumber, quickPickLottoTickets)
        val matchResult = matchingLottoNumber.getMatchResult()
        val expectedResults = listOf(
            Prize.FIRST,
            Prize.SECOND,
            Prize.THIRD,
            Prize.FOURTH,
            Prize.FIFTH,
            Prize.NONE
        )
        assertEquals(expectedResults, matchResult)
    }
}