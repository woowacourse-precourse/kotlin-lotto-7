package lotto.model

import lotto.util.Constants.LOTTO_PRICE
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import lotto.model.LottoRank.Rank

class LottoMachineTest {

    private val lottoMachine = LottoMachine()
    private val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
    private val bonusNumber = 7

    @Test
    fun `구입 금액이 0일 때 로또를 구입하면 빈 리스트를 반환한다`() {
        val purchaseAmount = 0
        val lottos = lottoMachine.issueLottos(purchaseAmount)

        assertTrue(lottos.isEmpty())
    }

    @Test
    fun `구입 금액이 로또 가격의 배수일 때 로또 수를 정확히 계산한다`() {
        val purchaseAmount = LOTTO_PRICE * 3
        val lottos = lottoMachine.issueLottos(purchaseAmount)

        assertEquals(3, lottos.size)
    }

    @Test
    fun `6개 일치했을 때 1등을 반환한다`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val ranks = lottoMachine.determineLottoRanks(listOf(lotto), winningNumbers, bonusNumber)

        assertEquals(Rank.FIRST, ranks[0].rank)
    }

    @Test
    fun `5개 일치하고 보너스 번호도 일치할 때 2등을 반환한다`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 7))
        val ranks = lottoMachine.determineLottoRanks(listOf(lotto), winningNumbers, bonusNumber)

        assertEquals(Rank.SECOND, ranks[0].rank)
    }

    @Test
    fun `5개 일치하고 보너스 번호는 일치하지 않을 때 3등을 반환한다`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 8))
        val ranks = lottoMachine.determineLottoRanks(listOf(lotto), winningNumbers, bonusNumber)

        assertEquals(Rank.THIRD, ranks[0].rank)
    }

    @Test
    fun `4개 일치하고 보너스 번호도 일치할 때 4등을 반환한다`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 7, 8))
        val ranks = lottoMachine.determineLottoRanks(listOf(lotto), winningNumbers, bonusNumber)

        assertEquals(Rank.FOURTH, ranks[0].rank)
    }

    @Test
    fun `4개 일치하고 보너스 번호는 일치하지 않을 때 4등을 반환한다`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 8, 9))
        val ranks = lottoMachine.determineLottoRanks(listOf(lotto), winningNumbers, bonusNumber)

        assertEquals(Rank.FOURTH, ranks[0].rank)
    }

    @Test
    fun `3개 일치하고 보너스 번호도 일치할 때 5등을 반환한다`() {
        val lotto = Lotto(listOf(1, 2, 3, 7, 8, 9))
        val ranks = lottoMachine.determineLottoRanks(listOf(lotto), winningNumbers, bonusNumber)

        assertEquals(Rank.FIFTH, ranks[0].rank)
    }

    @Test
    fun `3개 일치하고 보너스 번호는 일치하지 않을 때 5등을 반환한다`() {
        val lotto = Lotto(listOf(1, 2, 3, 8, 9, 10))
        val ranks = lottoMachine.determineLottoRanks(listOf(lotto), winningNumbers, bonusNumber)

        assertEquals(Rank.FIFTH, ranks[0].rank)
    }

    @Test
    fun `일치하는 번호가 3개 미만일 때 미당첨을 반환한다`() {
        val lotto = Lotto(listOf(1, 2, 8, 9, 10, 11))
        val ranks = lottoMachine.determineLottoRanks(listOf(lotto), winningNumbers, bonusNumber)

        assertEquals(Rank.NO_WIN, ranks[0].rank)
    }
}
