package lotto.model

import lotto.utils.ErrorMessage

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { ErrorMessage.INVALID_WINNING_NUMBERS.getMessage() }
    }
    // TODO: 추가 기능 구현

}
