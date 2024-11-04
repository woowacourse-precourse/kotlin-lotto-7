package lotto

class PrizeChecker(private val winningNumbers: Lotto, private val bonusNumber: Int) {
    fun check(lottos: List<Lotto>): Map<Result, Int> {
        return lottos.groupingBy { lotto ->
            val matchCount = lotto.getNumbers().intersect(winningNumbers.getNumbers().toSet()).size
            val hasBonus = lotto.getNumbers().contains(bonusNumber)
            Result.from(matchCount, hasBonus)
        }.eachCount()
    }
}
