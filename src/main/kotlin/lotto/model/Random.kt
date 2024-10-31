package lotto.model

import camp.nextstep.edu.missionutils.Randoms

class Random {
    fun generateUniqueRandomList(): List<Int>
        = Randoms.pickUniqueNumbersInRange(RANDOM_MIN_NUMBER, RANDOM_MAX_NUMBER, Lotto.LOTTO_SIZE).sorted()

    companion object {
        const val RANDOM_MAX_NUMBER = 45
        const val RANDOM_MIN_NUMBER = 1
    }
}