package lotto.model.lotto

import lotto.model.message.ErrorMessage

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == 6) { ErrorMessage.INPUT_WINNING_6_NUMBERS.message }
        require(numbers.all { it in 1..45 }) { ErrorMessage.INPUT_1_TO_45.message }
        require(numbers.toSet().size == numbers.size) {ErrorMessage.INPUT_DUPLICATION.message}
    }
}
