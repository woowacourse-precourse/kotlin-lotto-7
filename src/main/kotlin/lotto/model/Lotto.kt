package lotto.model

import lotto.utils.WinningNumbers

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == WinningNumbers.WINNING_NUMBER_COUNT.value) { "[ERROR] 로또 번호는 ${WinningNumbers.WINNING_NUMBER_COUNT.value}개여야 합니다." }
    }

    // TODO: 추가 기능 구현
    fun getNumbers(): List<Int> {
        return numbers
    }
}
