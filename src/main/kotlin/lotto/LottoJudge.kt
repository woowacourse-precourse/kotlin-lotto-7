package lotto

class LottoJudge {
    var winnerNumbers: List<Int> = emptyList()

    fun setLottoWinnerNumbers(numbers: List<Int>) {
        exceptWinnerNumberCount(numbers)
        exceptWinnerNumberRange(numbers)
        winnerNumbers = numbers
    }

    private fun exceptWinnerNumberCount(numbers: List<Int>) {
        if (numbers.size != 6) {
            throw IllegalArgumentException(ErrorMessage.INPUT_WINNER_NUMBER_COUNT_ERROR.getMessage())
        }
    }

    private fun exceptWinnerNumberRange(numbers: List<Int>) {
        if (numbers.any { it < 1 || it > 45 }) {
            throw IllegalArgumentException(ErrorMessage.INPUT_WINNER_NUMBER_OUT_OF_RANGE_COUNT_ERROR.getMessage())
        }
    }
}