package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LottoResultTest {

    private lateinit var lottoResult: LottoResult
    private val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
    private val bonusNumber = 7

    @BeforeEach
    fun setUp() {
        lottoResult = LottoResult()
    }

    @Test
    fun `등급별로 올바른 결과를 반환한다`() {
        val tickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(1, 2, 3, 4, 5, 7)),
            Lotto(listOf(1, 2, 3, 4, 5, 8)),
            Lotto(listOf(1, 2, 3, 4, 9, 10)),
            Lotto(listOf(1, 2, 3, 11, 12, 13)),
            Lotto(listOf(10, 20, 30, 40, 41, 42))
        )

        val result = lottoResult.getRankedTickets(tickets, winningNumbers, bonusNumber)

        assertThat(result[Rank.FIRST]).isEqualTo(1)
        assertThat(result[Rank.SECOND]).isEqualTo(1)
        assertThat(result[Rank.THIRD]).isEqualTo(1)
        assertThat(result[Rank.FOURTH]).isEqualTo(1)
        assertThat(result[Rank.FIFTH]).isEqualTo(1)
        assertThat(result[Rank.NONE]).isEqualTo(1)
    }

    @Test
    fun `티켓이 없으면 빈 결과를 반환한다`() {
        val tickets = emptyList<Lotto>()

        val result = lottoResult.getRankedTickets(tickets, winningNumbers, bonusNumber)

        assertThat(result).isEmpty()
    }

    @Test
    fun `모든 티켓이 NONE 등급일 때 NONE 등급 개수만 카운트된다`() {
        val tickets = listOf(
            Lotto(listOf(10, 20, 30, 40, 41, 42)),
            Lotto(listOf(11, 21, 31, 41, 42, 43)),
            Lotto(listOf(12, 22, 32, 42, 43, 44))
        )

        val result = lottoResult.getRankedTickets(tickets, winningNumbers, bonusNumber)

        assertThat(result[Rank.NONE]).isEqualTo(3)
        assertThat(result[Rank.FIRST]).isNull()
        assertThat(result[Rank.SECOND]).isNull()
    }
}