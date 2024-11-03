package lotto.domain

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_NUMBER_SIZE) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbers.size == numbers.toSet().size) { "[ERROR] 로또 번호는 중복될 수 없습니다." }
        require(numbers.all { it in MINIMUM_NUMBER..MAXIMUM_NUMBER })
    }

    fun getNumbers(): List<Int> = numbers

    companion object {
        const val PRICE = 1000
        const val LOTTO_NUMBER_SIZE = 6
        const val MINIMUM_NUMBER = 1
        const val MAXIMUM_NUMBER = 45
    }
}


