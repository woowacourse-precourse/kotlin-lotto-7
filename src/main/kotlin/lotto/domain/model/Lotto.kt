package lotto.domain.model

import lotto.domain.exception.ExceptionMessages

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == VALID_LOTTO_NUMBER_LENGTH) { ExceptionMessages.INVALID_LOTTO_NUMBER_LENGTH }
        require(numbers.distinct().size == numbers.size) { ExceptionMessages.DUPLICATE_NUMBER_EXISTS }
        require(numbers.all { number -> number in VALID_LOTTO_NUMBER_RANGE }) {
            ExceptionMessages.NUMBER_OUT_OF_VALID_LOTTO_RANGE_EXISTS
        }
    }

    fun calculateWinPlace(winningNumbers: List<Int>, bonusWinningNumber: Int): LottoWinPlace? {
        val matchedNumbers = getMatchedNumbers(winningNumbers)
        val isBonusWinningNumberMatched = bonusWinningNumber in numbers
        return LottoWinPlace.findLottoWinPlace(matchedNumbers.size, isBonusWinningNumberMatched)
    }

    private fun getMatchedNumbers(winningNumbers: List<Int>) = numbers.toSet().intersect(winningNumbers.toSet())

    override fun toString(): String = numbers.sorted().toString()

    companion object {
        const val LOTTO_PRICE = 1_000
        const val VALID_LOTTO_NUMBER_LENGTH = 6
        val VALID_LOTTO_NUMBER_RANGE = 1..45
    }
}
