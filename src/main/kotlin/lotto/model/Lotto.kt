package lotto.model

import lotto.WinLotteryValidator

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_SIZE) { WinLotteryValidator.ERROR_TOO_MANY_LOTTO_NUMBER.msg }
    }

    companion object {
        const val LOTTO_SIZE = 6
    }

    override fun toString(): String {
        return "$numbers"
    }

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
