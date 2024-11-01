package lotto

class LottoJudge {
    var winnerNumbers: List<Int> = emptyList()

    fun setLottoWinnerNumbers(numbers: List<Int>) {
        if (numbers.size != 6) {
            throw IllegalArgumentException(ErrorMessage.INPUT_WINNER_NUMBER_COUNT_ERROR.getMessage())
        }
        winnerNumbers = numbers
    }
}