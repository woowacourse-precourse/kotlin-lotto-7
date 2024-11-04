package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.util.Constants

class LottoGame {

    fun generateLotto(count: Int): List<Lotto> {
        val lotto = List(count) { Lotto(generateRandomNumbers()) }

        return lotto
    }

    private fun generateRandomNumbers(): List<Int> {
        val randomNumbers = Randoms.pickUniqueNumbersInRange(
            Constants.MIN_NUMBER,
            Constants.MAX_NUMBER,
            Constants.WINNING_NUMBERS_COUNT
        )
        return randomNumbers
    }
}