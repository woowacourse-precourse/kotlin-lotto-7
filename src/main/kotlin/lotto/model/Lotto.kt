package lotto.model

import lotto.Validator
import lotto.WinLotteryValidator

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_SIZE) { WinLotteryValidator.ERROR_TOO_MANY_LOTTO_NUMBER.msg }
        require(Validator.isOutOfRange(numbers)) { WinLotteryValidator.ERROR_OUT_OF_RANGE.msg }
        require(Validator.isNotExistDuplicateNumber(numbers)) { WinLotteryValidator.ERROR_DUPLICATE_LOTTO_NUMBER.msg }
    }

    companion object {
        const val LOTTO_SIZE = 6
    }

    override fun toString(): String {
        return "$numbers"
    }

    fun getNumbers(): List<Int> = numbers

    fun getMatchCount(winLotto: Lotto): Int {
        var count = 0
        for (i in numbers) {
            if (i in winLotto.numbers) count++
        }
        return count
    }

    fun isMatchBonusNumber(bonusNumber: Int): Boolean {
        return bonusNumber in numbers
    }

}
