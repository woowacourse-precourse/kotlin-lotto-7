package lotto.model

import lotto.Constants

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == Constants.WINNING_NUMBER_COUNT) { "[ERROR] 로또 번호는 ${Constants.WINNING_NUMBER_COUNT}개여야 합니다." }
    }

    // TODO: 추가 기능 구현
    fun getNumbers(): List<Int> {
        return numbers
    }
}
