package lotto.domain.lotto

import lotto.dto.MatchedInfoDto
import lotto.validator.LottoValidator

class Lotto(private val numbers: List<Int>) {
    init {
        LottoValidator.validate(numbers)
    }

    fun getMatchedInfo(winningLotto: Lotto, bonusNumber: BonusNumber): MatchedInfoDto {
        val matchedCount = matchedWinningNumberCount(winningLotto)
        val hasBonusNumber = hasBonusNumber(bonusNumber)
        return MatchedInfoDto(matchedCount, hasBonusNumber)
    }

    private fun matchedWinningNumberCount(winningLotto: Lotto): Int {
        return this.numbers.count { winningLotto.isMatched(it) }
    }

    private fun isMatched(number: Int): Boolean {
        return this.numbers.contains(number)
    }

    private fun hasBonusNumber(bonusNumber: BonusNumber): Boolean {
        return numbers.contains(bonusNumber.number)
    }

    fun isDuplicateNumber(number: Int): Boolean {
        return this.numbers.contains(number)
    }

    override fun toString(): String {
        return numbers.joinToString(separator = ", ", prefix = "[", postfix = "]") { it.toString() }
    }
}
