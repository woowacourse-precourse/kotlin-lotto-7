package lotto.model

import camp.nextstep.edu.missionutils.Randoms

class LottoGenerator {

    fun generator(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, COUNT)
    }

    companion object {
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
        const val COUNT = 6
    }
}