package lotto


const val PRIZE_MONEY_3 = 5000
const val PRIZE_MONEY_4 = 50000
const val PRIZE_MONEY_5 = 1500000
const val PRIZE_MONEY_5_BONUS = 30000000
const val PRIZE_MONEY_6 = 2000000000

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
    }


}
