package lotto.model

import lotto.util.validator.LottoNumberValidator

class Lotto(private val numbers: List<Int>) {
    init {
        LottoNumberValidator.validateLottoNumbers(numbers)
    }

    fun getLottoNumber(): List<Int> = numbers

    fun getLottoRank(winningNumber: List<Int>, bonusNumber: Int): LottoRank {
        val matchedCount = numbers.count { number -> number in winningNumber }
        val isBonusNumberMatched = bonusNumber in numbers
        val lottoRank = LottoRank.fromMatchedCount(matchedCount, isBonusNumberMatched)
        return lottoRank
    }
}
