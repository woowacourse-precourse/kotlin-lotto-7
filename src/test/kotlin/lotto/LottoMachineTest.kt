package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class LottoMachineTest {

    @Test
    fun releaseLottoTest() {
        val releaseCount = 5000
        val releaseLottos = LottoMachine.releaseLotto(releaseCount)

        assert(releaseLottos.size == releaseCount)
    }

    @Test
    fun calculateRankTest() {

        assertRandomUniqueNumbersInRangeTest({
            val purchaseCost = 6000
            val lottos = LottoMachine.releaseLotto(purchaseCost)
            val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
            val bonus = 7

            assert(LottoMachine.lottoRank(lottos[0].getNumbers(), winningNumbers, bonus) == LottoMachine.Rank.FIRST)
            assert(LottoMachine.lottoRank(lottos[1].getNumbers(), winningNumbers, bonus) == LottoMachine.Rank.SECOND)
            assert(LottoMachine.lottoRank(lottos[2].getNumbers(), winningNumbers, bonus) == LottoMachine.Rank.THIRD)
            assert(LottoMachine.lottoRank(lottos[3].getNumbers(), winningNumbers, bonus) == LottoMachine.Rank.FORTH)
            assert(LottoMachine.lottoRank(lottos[4].getNumbers(), winningNumbers, bonus) == LottoMachine.Rank.FIFTH)
            assert(LottoMachine.lottoRank(lottos[5].getNumbers(), winningNumbers, bonus) == LottoMachine.Rank.LOSE)
        },
            listOf(1, 2, 3, 4, 5, 6),
            listOf(2, 3, 4, 5, 6, 7),
            listOf(2, 3, 4, 5, 6, 35),
            listOf(3, 4, 5, 6, 7, 8),
            listOf(4, 5, 6, 7, 8, 9),
            listOf(5, 6, 7, 8, 9, 10),
        )
    }
}