package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LottoMaker.NUMBERS_COUNT) { ErrorMessage.LOTTO_NUMBER_COUNT_ERROR.getMessage() }
        require(numbers.toSet().size == numbers.size) { ErrorMessage.LOTTO_NUMBER_NO_DUPLICATE.getMessage() }
        println(numbers.sorted())
    }

    fun checkRank(winningNumbers: List<Int>, bonusNumber: Int): LottoRank {
        val winningNumbersCount = countCommonNumbers(winningNumbers, numbers)
        return LottoRank.getRank(winningNumbersCount, numbers.contains(bonusNumber))
    }

    private fun countCommonNumbers(list1: List<Int>, list2: List<Int>): Int {
        return list1.intersect(list2).size
    }
}
