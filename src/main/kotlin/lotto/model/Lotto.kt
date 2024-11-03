package lotto.model

import lotto.utils.Validator

class Lotto(private val numbers: List<Int>) {
    init {
        Validator.validateLotto(this)
    }

    fun getNumbers() = numbers
}
