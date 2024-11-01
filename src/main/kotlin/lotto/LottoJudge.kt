package lotto

class LottoJudge {
    var winnerNumbers: List<Int> = emptyList()

    fun setLottoWinnerNumber(number: List<Int>) {
        winnerNumbers = number
    }
}