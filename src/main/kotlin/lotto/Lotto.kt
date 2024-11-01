package lotto

import lotto.Model.LottoRank

class Lotto(private val numbers: List<Int>) {
    init {
        val nameCounts = numbers.groupingBy { it }.eachCount()
        val minNum = numbers.minOf { it }
        val maxNum = numbers.maxOf { it }
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(nameCounts.maxOf { it.value } == 1) { "[ERROR] 로또 번호는 중복되지 않아야 합니다." }
        require(minNum >= 1 && maxNum <= 45) { "[ERROR] 로또 번호는 1부터 45 사이의 값이어야 합니다." }
    }

    fun checkIfMatchBonusNumber(bonusNumber: Int): Boolean {
        return numbers.contains(bonusNumber)
    }

    fun getNumbers(): List<Int> {
        return numbers
    }

    fun getLottoResult(winningLotto: Lotto, bonusNumber: Int): LottoRank {
        val winningLottoNumbers = winningLotto.getNumbers()
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
}
