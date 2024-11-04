package lotto.model

class LottoNumber(private val number: Int) {
    init {
        require(number in NUMBER_RANGE ) { "[ERROR] 로또 번호는 ${Lotto.MIN_NUMBER}부터 ${Lotto.MAX_NUMBER}사이의 숫자여야 합니다" }
    }

    fun getNumber(): Int = number

    companion object {
        val NUMBER_RANGE = Lotto.MIN_NUMBER..Lotto.MAX_NUMBER
    }
}
