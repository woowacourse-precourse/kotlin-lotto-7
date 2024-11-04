package lotto.dto

import lotto.Lotto

class Money(private val money: Int) {

    init {
        require(money % Lotto.PRICE == 0) { "[ERROR] 구입 금액을 ${Lotto.PRICE}단위로 입력되어야 합니다." }
        require(money != 0) { "[Error] 0원은 입력 불가합니다." }
    }

    fun calculateNumberOfLotto(): Int = money / Lotto.PRICE


    companion object {
        fun validateMoney(input: String?): Money {
            // 숫자가 아닌 것이 들어온 경우
            if (input.isNullOrBlank()) throw IllegalArgumentException("[ERROR] 구입 금액에는 숫자만 입력 가능합니다.")

            val trimmedInput = input.trim()
            val regex = Regex("^[0-9]+$")
            if (!trimmedInput.matches(regex)) throw IllegalArgumentException("[ERROR] 구입 금액에는 숫자만 입력 가능합니다.")

            val money = trimmedInput.toInt()

            return Money(money)
        }
    }
}