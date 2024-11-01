package lotto.model

import lotto.util.LottoNumberValidator

// 로또 번호의 에러 체크
// 로또 번호 제공
// 로또 당첨 여부확인
// 로또 보너스 번호 체크
class Lotto(private val numbers: List<Int>) {
    init {
        validateLottoNumber(numbers)
    }

    fun getLottoNumber(): List<Int> = numbers

    fun getLottoRank(winningNumber: List<Int>, bonusNumber: Int): Int {
        val matchedCount = numbers.count { number -> number in winningNumber }
        val lottoRank = determineRank(matchedCount, bonusNumber)
        return lottoRank
    }

    private fun determineRank(matchedCount: Int, bonusNumber: Int): Int {
        val lottoRank = when (matchedCount) {
            6 -> 1
            5 -> determineSecondRank(bonusNumber)
            4 -> 4
            3 -> 5
            else -> 0
        }
        return lottoRank
    }

    private fun determineSecondRank(bonusNumber: Int): Int {
        if (bonusNumber in numbers) {
            return 2
        }
        return 3
    }

    private fun validateLottoNumber(numbers: List<Int>) {
        LottoNumberValidator.validateLottoNumberCount(numbers)
        LottoNumberValidator.validateLottoNumberRange(numbers)
        LottoNumberValidator.validateLottoNumberUniqueness(numbers)
    }
}
