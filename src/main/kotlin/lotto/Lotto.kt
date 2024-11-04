package lotto

import lotto.dto.Bonus

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
    }

    // TODO: 추가 기능 구현
    fun getLotto(): List<Int> = numbers

    fun isDuplicate(): Boolean = numbers.toSet().size == SIZE

    fun compareWithLotto(lotto: Lotto): Int {
        var match = 0
        lotto.getLotto().forEach {
            if (numbers.contains(it)) match++
        }
        return match
    }

    fun compareWithBonus(bonus: Bonus): Boolean {
        return numbers.contains(bonus.getBonusNumber())
    }

    companion object {
        const val PRICE: Int = 1000
        const val SIZE: Int = 6
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45

        fun validateLotto(input: String?): Lotto {
            val regex = Regex("^[0-9,]+\$")
            if (input.isNullOrBlank() || !regex.matches(input)) throw IllegalArgumentException("[ERROR] 당첨 번호에는 쉼표(,)외에는 숫자만 입력가능 합니다")
            val numbers = input.replace(" ", "").split(",").map {
                it.toInt()
            }.sorted()

            return Lotto(numbers)
        }
    }
}
