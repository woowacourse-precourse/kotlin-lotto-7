package utils

import utils.ExtensionUtil.getInt

object Validator {

    fun validateMoney(inputMoney: String) {

        val money = inputMoney.getInt() ?: throw IllegalArgumentException("금액은 숫자로 입력해야 합니다.")

        require(money >= 0) { "금액은 양수로 입력해야 합니다." }

        require(money % 1000 == 0) { "금액은 1,000원 단위로 입력해야 합니다." }
    }

    fun validateWinningNumbers(inputWinningNumbers: String) {
        val winningNumbers = inputWinningNumbers.split(",")

        require(winningNumbers.size == 6) { "당첨 번호는 6개여야 합니다." }

        val numbers = winningNumbers.map {
            it.getInt()
                ?: throw IllegalArgumentException("당첨 번호는 숫자로 입력해야 합니다.")
        }

        require(numbers.all { it in 1..45 }) { "당첨 번호는 1~45 사이의 숫자여야 합니다." }

        require(numbers.toSet().size == 6) { "당첨 번호는 중복되어서는 안됩니다." }
    }


}