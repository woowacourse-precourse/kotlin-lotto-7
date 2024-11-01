package lotto.model

import lotto.util.Constant
import lotto.util.ErrorMessage

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == Constant.LOTTO_NUMBERS_COUNT) { ErrorMessage.LOTTO_NUMBERS_COUNT_MISMATCH }
    }

    // TODO: 추가 기능 구현
}
