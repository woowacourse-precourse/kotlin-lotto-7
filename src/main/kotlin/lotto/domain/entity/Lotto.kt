package lotto.domain.entity

import lotto.domain.validator.LottoNumberValidator

class Lotto(
    private val numbers: List<Int>,
    validator: LottoNumberValidator = lottoNumberValidator
) {
    init {
        validator.validateLottoNumbers(numbers)
    }

    fun getNumbers() = numbers.toList()

    companion object {
        private val lottoNumberValidator by lazy { LottoNumberValidator() }
    }
}
