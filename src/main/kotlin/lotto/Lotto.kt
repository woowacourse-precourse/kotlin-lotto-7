package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        Validator().checkLottoNumber(numbers)
    }

    fun getWinningNumbers(): List<Int> {
        return numbers
    }
}