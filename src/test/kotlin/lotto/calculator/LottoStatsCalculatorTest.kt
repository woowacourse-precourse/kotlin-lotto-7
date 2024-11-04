package lotto.calculator

import lotto.enums.Rank
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Assertions.assertEquals

class LottoStatsCalculatorTest {

    private lateinit var winningNumbers: List<Int>
    private var bonusNumber: Int = 0

    @BeforeEach
    fun setup() {
        winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        bonusNumber = 7
    }

    @Test
    fun `6개 일치 시 1등`() {
        val tickets = listOf(listOf(1, 2, 3, 4, 5, 6))
        val calculator = LottoStatsCalculator(tickets, winningNumbers, bonusNumber)

        assertEquals(listOf(Rank.FIRST), calculator.getLottoStats())
    }

    @Test
    fun `5개 일치 + 보너스 번호 일치 시 2등`() {
        val tickets = listOf(listOf(1, 2, 3, 4, 5, 7))
        val calculator = LottoStatsCalculator(tickets, winningNumbers, bonusNumber)

        assertEquals(listOf(Rank.SECOND), calculator.getLottoStats())
    }

    @Test
    fun `5개 일치 + 보너스 번호 불일치 시 3등`() {
        val tickets = listOf(listOf(1, 2, 3, 4, 5, 8))
        val calculator = LottoStatsCalculator(tickets, winningNumbers, bonusNumber)

        assertEquals(listOf(Rank.THIRD), calculator.getLottoStats())
    }

    @Test
    fun `4개 일치 시 4등`() {
        val tickets = listOf(listOf(1, 2, 3, 4, 10, 11))
        val calculator = LottoStatsCalculator(tickets, winningNumbers, bonusNumber)

        assertEquals(listOf(Rank.FOURTH), calculator.getLottoStats())
    }

    @Test
    fun `3개 일치 시 5등`() {
        val tickets = listOf(listOf(1, 2, 3, 10, 11, 12))
        val calculator = LottoStatsCalculator(tickets, winningNumbers, bonusNumber)

        assertEquals(listOf(Rank.FIFTH), calculator.getLottoStats())
    }

    @Test
    fun `2개 이하 일치 시 등수 없음`() {
        val tickets = listOf(listOf(1, 2, 10, 11, 12, 13))
        val calculator = LottoStatsCalculator(tickets, winningNumbers, bonusNumber)

        assertEquals(emptyList<Rank>(), calculator.getLottoStats())
    }

    @Test
    fun `여러 개의 당첨 티켓`() {
        val tickets = listOf(listOf(1, 2, 3, 4, 10, 11), listOf(1, 2, 10, 11, 12, 13), listOf(1, 2, 3, 4, 5, 8))
        val calculator = LottoStatsCalculator(tickets, winningNumbers, bonusNumber)

        assertEquals(listOf(Rank.FOURTH, Rank.THIRD), calculator.getLottoStats())
    }
}