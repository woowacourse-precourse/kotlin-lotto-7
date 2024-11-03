package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LottoMaker.NUMBERS_COUNT) { ErrorMessage.LOTTO_NUMBER_COUNT_ERROR }
        require(numbers.toSet().size == numbers.size) { ErrorMessage.LOTTO_NUMBER_NO_DUPLICATE }
    }

    fun checkRank(winnerNumbers: List<Int>, bonusNumber: Int): LottoRank {
        val winNumbersCount = countCommonNumbers(winnerNumbers, numbers)
        return LottoRank.getRank(winNumbersCount, numbers.contains(bonusNumber))
    }

    private fun countCommonNumbers(list1: List<Int>, list2: List<Int>): Int {
        return list1.intersect(list2).size
    }
}
