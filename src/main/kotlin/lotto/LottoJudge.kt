package lotto

class LottoJudge {
    var winnerNumbers: List<Int> = emptyList()
    var bonusNumber: Int = 0

    fun setLottoWinnerNumbers(numbers: List<Int>) {
        exceptWinnerNumberCount(numbers)
        exceptWinnerNumberRange(numbers)
        winnerNumbers = numbers
    }

    fun setLottoBonusNumber(number: Int) {
        exceptBonusNumberRange(number)
        bonusNumber = number
    }

    private fun exceptWinnerNumberCount(numbers: List<Int>) {
        if (numbers.size != 6) {
            throw IllegalArgumentException(ErrorMessage.INPUT_WINNER_NUMBER_COUNT_ERROR.getMessage())
        }
    }

    private fun exceptWinnerNumberRange(numbers: List<Int>) {
        if (numbers.any { it < 1 || it > 45 }) {
            throw IllegalArgumentException(ErrorMessage.INPUT_WINNER_NUMBER_OUT_OF_RANGE_ERROR.getMessage())
        }
    }

    private fun exceptBonusNumberRange(number: Int) {
        if (number < 1 || number > 45 ) {
            throw IllegalArgumentException(ErrorMessage.INPUT_WINNER_NUMBER_OUT_OF_RANGE_ERROR.getMessage())
        }
    }
}