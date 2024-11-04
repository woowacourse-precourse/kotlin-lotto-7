package lotto.model

import lotto.validation.InputValidation

class Lotto(private val numbers: List<Int>) {
    private val validator = InputValidation()

    init {
        validator.lottoNumbers(numbers)
    }

    fun getLottoNumbers(): List<Int> {
        return numbers
    }
}
