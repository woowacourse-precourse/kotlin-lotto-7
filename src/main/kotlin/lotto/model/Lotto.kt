package lotto.model

import lotto.util.constant.LottoRules
import lotto.util.validator.LottoNumberValidator

// 로또 번호의 에러 체크
// 로또 번호 제공
// 로또 당첨 여부확인
// 로또 보너스 번호 체크
class Lotto(private val numbers: List<Int>) {
    init {
        LottoNumberValidator.validateLottoNumbers(numbers)
    }

    fun getLottoNumber(): List<Int> = numbers

    fun getLottoRank(winningNumber: List<Int>, bonusNumber: Int): Int {
        val matchedCount = numbers.count { number -> number in winningNumber }
        val lottoRank = determineRank(matchedCount, bonusNumber)
        return lottoRank
    }

    private fun determineRank(matchedCount: Int, bonusNumber: Int): Int {
        val lottoRank = when (matchedCount) {
            LottoRules.MATCHED_SIX -> LottoRules.RANK_FIRST
            LottoRules.MATCHED_FIVE -> determineSecondRank(bonusNumber)
            LottoRules.MATCHED_FOUR -> LottoRules.RANK_FOURTH
            LottoRules.MATCHED_THREE -> LottoRules.RANK_FIFTH
            else -> LottoRules.OUT_OF_RANK
        }
        return lottoRank
    }

    private fun determineSecondRank(bonusNumber: Int): Int {
        if (bonusNumber in numbers) {
            return LottoRules.RANK_SECOND
        }
        return LottoRules.RANK_THIRD
    }
}
