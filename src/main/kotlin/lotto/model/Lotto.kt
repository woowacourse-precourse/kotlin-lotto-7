package lotto.model

import lotto.Validator

class Lotto(private val numbers: List<Int>) {
    init {
        Validator().checkLottoNumber(numbers)
    }
}
