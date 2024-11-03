package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.view.LottoGameViewMessage

const val WINNING_NUMBERS_SIZE = 6
const val LOTTO_NUMBER_MIN_VALUE = 1
const val LOTTO_NUMBER_MAX_VALUE = 45

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbers.distinct().size == numbers.size) { LottoGameViewMessage.ERROR_DUPLICATED_WINNING_NUMBERS.getErrorMessage() }
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


    override fun toString(): String {
        return numbers.joinToString(prefix = "[", postfix = "]", separator = ", ")
    }

    fun getLottNumbers(): List<Int> {
        return numbers
    }
}
