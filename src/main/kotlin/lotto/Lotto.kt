package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LottoMaker.NUMBERS_COUNT) { ErrorMessage.LOTTO_NUMBER_COUNT_ERROR }
        require(numbers.toSet().size == numbers.size) { ErrorMessage.LOTTO_NUMBER_NO_DUPLICATE }
    }

    fun checkRank(winnerNumbers: List<Int>, bonusNumber: Int): LottoRank {
        val winNumbersCount = countCommonNumbers(winnerNumbers, numbers)
        if (winNumbersCount == 6) {
            return LottoRank.FIRST
        }
        if (winNumbersCount == 5) {
            if (numbers.contains(bonusNumber)) {
                return LottoRank.SECOND
            }
            return LottoRank.THIRD
        }
        if (winNumbersCount == 4) {
            return LottoRank.FOURTH
        }
        if (winNumbersCount == 3) {
            return LottoRank.FIFTH
        }

        return LottoRank.FOURTH
    }

    private fun countCommonNumbers(list1: List<Int>, list2: List<Int>): Int {
        return list1.intersect(list2).size
    }
}
