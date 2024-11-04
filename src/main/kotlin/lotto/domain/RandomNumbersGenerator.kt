package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

class RandomNumbersGenerator : NumbersGenerator {

    override fun generate(): List<Int> {
        val randomNumbers = Randoms.pickUniqueNumbersInRange(START_RANGE, END_RANGE, COUNT)
        return randomNumbers
    }

    companion object {
        private const val START_RANGE = 1
        private const val END_RANGE = 45
        private const val COUNT = 6
    }
}
