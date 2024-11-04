package lotto.model

class LottoNumber(private val number: Int) {
    init {
        require(number in NUMBER_RANGE ) { "[ERROR] 로또 번호는 ${MIN_NUMBER}부터 ${MAX_NUMBER}사이의 숫자여야 합니다" }
    }

    fun getNumber(): Int = number

    companion object {
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
        val NUMBER_RANGE = MIN_NUMBER..MAX_NUMBER
    }
}
