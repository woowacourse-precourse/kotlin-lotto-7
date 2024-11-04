package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

class LottoGenerator {
    fun generate(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(
            MIN_LOTTO_NUMBER,
            MAX_LOTTO_NUMBER,
            LOTTO_NUMBERS_COUNT
        )
        return Lotto(numbers)
    }

    companion object {
        private const val MIN_LOTTO_NUMBER = 1
        private const val MAX_LOTTO_NUMBER = 45
        private const val LOTTO_NUMBERS_COUNT = 6
    }
}