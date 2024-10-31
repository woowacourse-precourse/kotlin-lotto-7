package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class LottoMachineTest {

    @Test
    fun calculateRank() {
        val lottoMachine = LottoMachine()

        assertRandomUniqueNumbersInRangeTest({
            val firstLotto = lottoMachine.createLotto()
            val secondLotto = lottoMachine.createLotto()
            val thirdLotto = lottoMachine.createLotto()
            val forthLotto = lottoMachine.createLotto()
            val fifthLotto = lottoMachine.createLotto()
            val sixthLotto = lottoMachine.createLotto()
            val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
            val bonus = 7

            assert(lottoMachine.lottoRank(firstLotto.getNumbers(), winningNumbers, bonus) == LottoMachine.Rank.FIRST)
            assert(lottoMachine.lottoRank(secondLotto.getNumbers(), winningNumbers, bonus) == LottoMachine.Rank.SECOND)
            assert(lottoMachine.lottoRank(thirdLotto.getNumbers(), winningNumbers, bonus) == LottoMachine.Rank.THIRD)
            assert(lottoMachine.lottoRank(forthLotto.getNumbers(), winningNumbers, bonus) == LottoMachine.Rank.FORTH)
            assert(lottoMachine.lottoRank(fifthLotto.getNumbers(), winningNumbers, bonus) == LottoMachine.Rank.FIFTH)
            assert(lottoMachine.lottoRank(sixthLotto.getNumbers(), winningNumbers, bonus) == LottoMachine.Rank.LOSE)
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