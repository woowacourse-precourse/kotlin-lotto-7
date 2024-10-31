package lotto.model

import camp.nextstep.edu.missionutils.Randoms

class Random {
    fun generateUniqueRandomList(): List<Int>
        = Randoms.pickUniqueNumbersInRange(RANDOM_MIN_NUMBER, RANDOM_MAX_NUMBER, RANDOM_LIST_SIZE)

    companion object {
        const val RANDOM_MAX_NUMBER = 45
        const val RANDOM_MIN_NUMBER = 1
        const val RANDOM_LIST_SIZE = 6
    }
}