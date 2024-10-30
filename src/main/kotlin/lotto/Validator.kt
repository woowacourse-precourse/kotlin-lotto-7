package lotto


object MoneyValidator {
    const val ERROR_EMPTY_MONEY = "[ERROR] 돈은 공백이거나 빈 값일 수 없습니다."
    const val ERROR_MINUS_MONEY = "[ERROR] 돈은 음수의 값을 가질 수 없습니다."
    const val ERROR_NOT_NUMBER = "[ERROR] 돈은 숫자만 입력하실 수 있습니다."
    const val ERROR_NOT_DIVIDE_UP_1000 = "[ERROR] 1000으로 나누어 떨어지는 숫자만 가능합니다."
}

object Validator {
    fun validatePurchaseMoney(s: String) {
        require(s.isNotBlank()) {
            MoneyValidator.ERROR_EMPTY_MONEY
        }
        require(s.toIntOrNull() != null) {
            MoneyValidator.ERROR_NOT_NUMBER
        }
        require(s.toInt() >= 0) {
            MoneyValidator.ERROR_MINUS_MONEY
        }
        require(s.toInt() % 1_000 == 0) {
            MoneyValidator.ERROR_NOT_DIVIDE_UP_1000
        }
    }
}