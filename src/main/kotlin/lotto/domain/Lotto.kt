package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.constant.ExceptionMessage.ERROR_DUPLICATE_NUMBER
import lotto.constant.ExceptionMessage.ERROR_NOT_ITEM_LENGTH
import lotto.constant.ExceptionMessage.ERROR_NOT_LOTTO_NUMBER
import lotto.constant.LottoRule.END_NUMBER
import lotto.constant.LottoRule.ITEM_LENGTH
import lotto.constant.LottoRule.START_NUMBER

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == ITEM_LENGTH) { ERROR_NOT_ITEM_LENGTH }
        numbers.forEach {
            require(it in START_NUMBER..END_NUMBER) { ERROR_NOT_LOTTO_NUMBER }
        }
        validateDuplicates(numbers)
    }

    fun getLottoRank(winLottoInfo: LottoWinningInfo): LottoRank {
        var matchCount = 0
        for (number in winLottoInfo.numbers) {
            if (numbers.contains(number)) {
                matchCount++
            }
        }
        val isBonusMatch = numbers.contains(winLottoInfo.bonusNumber)

        return LottoRank.getRank(matchCount, isBonusMatch)
    }

    override fun toString(): String {
        return numbers.sorted().toString()
    }

    private fun validateDuplicates(numbers: List<Int>) {
        val filterNumbers = numbers.toSet()
        require(filterNumbers.size == ITEM_LENGTH) { ERROR_DUPLICATE_NUMBER }
    }

    companion object {
        fun create(): Lotto {
            return Lotto(Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, ITEM_LENGTH))
        }
    }
}
