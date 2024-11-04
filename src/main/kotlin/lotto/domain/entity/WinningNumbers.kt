package lotto.domain.entity

import lotto.domain.validator.LottoNumbersValidator

class WinningNumbers(
    private val numbers: List<Int>,
    validator: LottoNumbersValidator = lottoNumbersValidator
) {

    init {
        validator.validateLottoNumbers(numbers)
    }

    fun getNumbers() = numbers.toList()

    companion object {
        private val lottoNumbersValidator by lazy { LottoNumbersValidator() }
    }
}