package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

const val WINNING_NUMBERS_SIZE = 6
const val LOTTO_NUMBER_MIN_VALUE = 1
const val LOTTO_NUMBER_MAX_VALUE = 45

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
    }

    companion object {
        fun generate(): Lotto {
            val randomNumbers =
                Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN_VALUE, LOTTO_NUMBER_MAX_VALUE, WINNING_NUMBERS_SIZE)
                    .sorted()
                    .toList()

            return Lotto(randomNumbers)
        }
    }
}
