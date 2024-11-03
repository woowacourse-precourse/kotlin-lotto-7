package lotto.model

import camp.nextstep.edu.missionutils.*

class LottoGenerator {

    fun generateLotto(money: Int): List<List<Int>> {
        val randomLotto: MutableList<List<Int>> = mutableListOf()
        val numberOfLotto = getNumberOfLotto(money)

        for (i in 0 until numberOfLotto) {
            randomLotto.add(getRandomNumbers())
        }
        return randomLotto
    }

    fun getNumberOfLotto(money: Int): Int {
        return money / 1000
    }

    private fun getRandomNumbers(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }
}
