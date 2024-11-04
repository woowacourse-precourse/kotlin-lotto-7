package lotto.dto

import lotto.Lotto

class Bonus(private val number: Int) {
    init {
        require(number in MIN_NUMBER..MAX_NUMBER) { "[ERROR] 보너스 번호는 1~45 사이의 수여야 합니다." }
    }

    fun getBonusNumber(): Int = number

    companion object {
        const val MIN_NUMBER = Lotto.MIN_NUMBER
        const val MAX_NUMBER = Lotto.MAX_NUMBER

        fun validateBonus(input: String?): Bonus {
            val regex = Regex("^[0-9]+$")
            if (input.isNullOrBlank() || !regex.matches(input)) throw IllegalArgumentException("[ERROR] 보너스 번호에는 숫자만 입력할 수 있습니다.")

            return Bonus(input.trim().toInt())
        }
    }
}