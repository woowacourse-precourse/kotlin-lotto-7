package lotto

import lotto.Model.LottoRank
import lotto.Model.WinningLottoResult

class Lotto(private val numbers: List<Int>) {
    init {
        val nameCounts = numbers.groupingBy { it }.eachCount()
        val minNum = numbers.minOf { it }
        val maxNum = numbers.maxOf { it }
        require(numbers.size == 6) { NUMBERS_SIZE_NOT_VALIDATE }
        require(nameCounts.maxOf { it.value } == 1) { NUMBERS_DUPLICATED }
        require(minNum >= MIN_VALUE && maxNum <= MAX_VALUE) { NUMBERS_NOT_BETWEEN_LOTTO_NUM }
    }

    fun checkIfMatchBonusNumber(bonusNumber: Int): Boolean {
        return numbers.contains(bonusNumber)
    }

    fun getNumbers(): List<Int> {
        return numbers
    }

    fun getLottoResult(winningLottoResult: WinningLottoResult): LottoRank {
        val firstRank = winningLottoResult.getWinningLotto()
        val bonusNumber = winningLottoResult.getBonusNumber()
        val winningLottoNumbers = firstRank.getNumbers()
        val numberMatchCount = getMatchCount(winningLottoNumbers)
        return getLottoRank(bonusNumber, numberMatchCount)
    }

    private fun getMatchCount(winningLotto: List<Int>): Int {
        var matchCount = 0
        numbers.forEach { number ->
            if (winningLotto.contains(number)) {
                matchCount++
            }
        }
        return matchCount
    }

    private fun getLottoRank(bonusNumber: Int, numberMatchCount: Int): LottoRank {
        if (numberMatchCount == 6)
            return LottoRank.First
        if (numberMatchCount == 5 && checkIfMatchBonusNumber(bonusNumber))
            return LottoRank.Second
        if (numberMatchCount == 5 && !checkIfMatchBonusNumber(bonusNumber))
            return LottoRank.Third
        if (numberMatchCount == 4)
            return LottoRank.Fourth
        if (numberMatchCount == 3)
            return LottoRank.Fifth
        return LottoRank.Lose
    }

    companion object {
        const val COST = 1000
        const val MIN_VALUE = 1
        const val MAX_VALUE = 45
        const val NUMBERS_SIZE_NOT_VALIDATE = "[ERROR] 로또 번호는 6개여야 합니다."
        const val NUMBERS_DUPLICATED = "[ERROR] 로또 번호는 중복되지 않아야 합니다."
        const val NUMBERS_NOT_BETWEEN_LOTTO_NUM = "[ERROR] 로또 번호는 ${MIN_VALUE}부터 $MAX_VALUE 사이의 값이어야 합니다."
    }
}
