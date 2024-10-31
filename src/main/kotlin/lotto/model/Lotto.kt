package lotto.model

import lotto.WinLotteryValidator

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_SIZE) { WinLotteryValidator.ERROR_TOO_MANY_LOTTO_NUMBER }
    }




    companion object {
        const val LOTTO_SIZE = 6
    }

    override fun toString(): String {
        return "$numbers"
    }
    // TODO: 추가 기능 구현
}
