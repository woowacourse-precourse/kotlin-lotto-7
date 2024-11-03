package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    init {
        checkNumbersAreValid()
    }

    private fun checkNumbersAreValid() {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbers.toSet().size == 6) { "[ERROR] 로또 번호에 중복된 숫자가 있습니다." }
        require(numbers.all { number -> number in 1..45 }) { "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다." }
    }

    fun getNumbers(): List<Int> = numbers.sorted()

    companion object {
        const val PRICE = 1_000
        fun generate(): Lotto {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            return Lotto(numbers)
        }
    }
}
