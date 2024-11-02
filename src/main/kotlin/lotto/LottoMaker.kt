package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoMaker {
    companion object {
        const val FIRST_NUMBER = 1
        const val LAST_NUMBER = 45
        const val NUMBERS_COUNT = 6

        fun make(): Lotto {
            val randomNumbers = Randoms.pickUniqueNumbersInRange(FIRST_NUMBER, LAST_NUMBER, NUMBERS_COUNT)
            return Lotto(randomNumbers)
        }
    }
}