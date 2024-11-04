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

    fun calculateMatchResult(resultNumbers: List<Int>): LottoMatchResult {
        val numbersForCheck = numbers.toSet()
        val lottoResult = LottoMatchResult()

        repeat(resultNumbers.size - 1) {
            if (it in numbersForCheck) lottoResult.matchNumbersCount += 1
        }
        if (resultNumbers.last() in numbersForCheck) lottoResult.isMatchBonus = true

        return lottoResult
    }
}
