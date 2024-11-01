package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

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
        require(filterNumbers.size == ITEM_LENGTH) { ERROR_NOT_DUPLICATE_NUMBER }
    }

    companion object {
        const val ITEM_LENGTH = 6
        const val START_NUMBER = 1
        const val END_NUMBER = 45
        const val PRICE = 1_000
        const val ERROR_NOT_ITEM_LENGTH = "[ERROR] 로또 번호는 6개여야 합니다."
        const val ERROR_NOT_LOTTO_NUMBER = "[ERROR] 로또 번호는 1부터 45까지 가능합니다."
        const val ERROR_NOT_DUPLICATE_NUMBER = "[ERROR] 로또 번호는 중복될 수 없습니다."
        fun create(): Lotto {
            return Lotto(Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, ITEM_LENGTH))
        }
    }
}
