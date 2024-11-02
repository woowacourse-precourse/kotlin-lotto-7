package lotto

class LottoJudge {
    var winnerNumbers: List<Int> = emptyList()
    var bonusNumber: Int = 0

    fun setLottoWinnerNumbers(numbers: List<Int>) {
        exceptWinnerNumberCount(numbers)
        exceptWinnerNumberRange(numbers)
        exceptDuplicates(numbers)
        winnerNumbers = numbers
    }

    fun setLottoBonusNumber(number: Int) {
        exceptBonusNumberRange(number)
        bonusNumber = number
    }

    private fun exceptWinnerNumberCount(numbers: List<Int>) {
        if (numbers.size != LottoMaker.NUMBERS_COUNT) {
            throw IllegalArgumentException(ErrorMessage.INPUT_WINNER_NUMBER_COUNT_ERROR.getMessage())
        }
    }

    private fun exceptWinnerNumberRange(numbers: List<Int>) {
        if (numbers.any { it < LottoMaker.FIRST_NUMBER || it > LottoMaker.LAST_NUMBER }) {
            throw IllegalArgumentException(ErrorMessage.INPUT_WINNER_NUMBER_OUT_OF_RANGE_ERROR.getMessage())
        }
    }

    private fun exceptBonusNumberRange(number: Int) {
        if (number < LottoMaker.FIRST_NUMBER || number > LottoMaker.LAST_NUMBER ) {
            throw IllegalArgumentException(ErrorMessage.INPUT_WINNER_NUMBER_OUT_OF_RANGE_ERROR.getMessage())
        }
    }

    private fun exceptDuplicates(numbers: List<Int>) {
        if (numbers.toSet().size != numbers.size) {
            throw IllegalArgumentException(ErrorMessage.INPUT_WINNER_NUMBER_NO_DUPLICATE.getMessage())
        }
    }
}