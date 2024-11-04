package lotto.model

import camp.nextstep.edu.missionutils.Randoms

class CreateLotto {
    fun random(): MutableList<Int>{
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }
}