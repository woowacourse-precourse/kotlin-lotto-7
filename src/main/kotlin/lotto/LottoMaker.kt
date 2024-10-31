package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoMaker {
    companion object {
        fun make(): Lotto {
            val randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            return Lotto(randomNumbers)
        }
    }
}