package lotto.model

import lotto.constants.ErrorMessage
import lotto.utils.Validation

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { ErrorMessage.LOTTO_COUNT_ERROR }
        require(numbers.distinct().size == numbers.size) { ErrorMessage.DUPLICATED_NUMBER }
    }

    fun getNumbers() = numbers

    fun getRank(winningLotto: Set<Int>, bonusNumber: Int): Rank {
        var count = 0
        var matchBonusNumber = false
        numbers.forEach { num ->
            if(winningLotto.contains(num)) count++
            if(num == bonusNumber) matchBonusNumber = true
        }
        return when(count) {
            3 -> Rank.FIFTH
            4 -> Rank.FOURTH
            5 -> if(matchBonusNumber) Rank.SECOND else Rank.THIRD
            6 -> Rank.FIRST
            else -> Rank.NONE
        }
    }
}
