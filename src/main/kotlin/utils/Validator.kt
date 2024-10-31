package utils

object Validator {

    fun validateMoney(inputMoney: String) {
        require(inputMoney.toIntOrNull() != null) { "금액은 숫자로 입력해야 합니다." }

        val money = inputMoney.toInt()

        require(money >= 0) { "금액은 양수로 입력해야 합니다." }

        require(money % 1000 == 0) { "금액은 1,000원 단위로 입력해야 합니다." }
    }
}