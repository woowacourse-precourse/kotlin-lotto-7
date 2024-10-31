package lotto.validator

const val MONEY_REGEX = "^\\d{1,3}(,\\d{3})*?$|^\\d+$"
const val AMOUNT_UNIT = 1000

class InputValidator {

    fun isValidMoney(input: String): Boolean {
        val regex = Regex(MONEY_REGEX)
        val money = input.replace(",", "").toIntOrNull()

        if (input == "") return false
        else if (!regex.matches(input)) return false
        else if (money == null) return false
        else if (money % AMOUNT_UNIT != 0 || money <= 0) return false

        return true
    }
}

enum class ValidatorMessage(val message: String) {
    INPUT_MONEY("잘못된 입력입니다.");

    fun display() {
        println("[Error] ${message}")
    }
}