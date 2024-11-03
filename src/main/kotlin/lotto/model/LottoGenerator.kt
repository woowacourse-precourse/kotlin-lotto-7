package lotto.model

import camp.nextstep.edu.missionutils.*
import lotto.constant.AMOUNT_UNIT
import lotto.constant.LOTTO_SIZE
import lotto.constant.MAX_LOTTO_NUM
import lotto.constant.MIN_LOTTO_NUM

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
        return money / AMOUNT_UNIT
    }

    private fun getRandomNumbers(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUM, MAX_LOTTO_NUM, LOTTO_SIZE)
    }
}
