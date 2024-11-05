package lotto.model

import camp.nextstep.edu.missionutils.Randoms

class Random {
    fun generateSixNumber(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }
}