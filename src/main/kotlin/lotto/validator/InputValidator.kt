package lotto.validator

const val MONEY_REGEX = "^\\d{1,3}(,\\d{3})*?$|^\\d+$"
const val AMOUNT_UNIT = 1000

class InputValidator {

    fun isValidMoney(input: String): Boolean {
        val regex = Regex(MONEY_REGEX)
        val money = input.replace(",", "").toIntOrNull()

        if (input == "") {
            ValidatorMessage.INVALID_INPUT.display()
            return false
        } else if (!regex.matches(input)) {
            ValidatorMessage.INVALID_INPUT.display()
            return false
        } else if (money == null) {
            ValidatorMessage.INVALID_INPUT.display()
            return false
        } else if (money % AMOUNT_UNIT != 0 || money <= 0) {
            ValidatorMessage.INVALID_INPUT.display()
            return false
        }

        return true
    }

    fun isValidWinningNum(input: String): Boolean {
        val inputNumbers = input.split(",").map { it.trim() }

        if (input == "") {
            ValidatorMessage.INVALID_INPUT.display()
            return false
        } else if (inputNumbers.size != 6) {
            ValidatorMessage.INVALID_COUNT_NUM.display()
            return false
        } else if (inputNumbers.size != inputNumbers.distinct().size) {
            ValidatorMessage.DUPLICATE_NUM.display()
            return false
        }
        inputNumbers.forEach {
            val num = it.toIntOrNull()
            if (num == null || num < 1 || num > 45) {
                ValidatorMessage.INVALID_RANGE_NUM.display()
                return false
            }
        }
        return true
    }

    fun isValidBonusNum(input: String, winningNum: String): Boolean {
        val num = input.toIntOrNull()
        val winningNumbers = winningNum.split(",").map { it.trim().toInt() }

        if (num == null || num < 1 || num > 45) {
            ValidatorMessage.INVALID_RANGE_NUM.display()
            return false
        } else if (winningNumbers.contains(num)) {
            ValidatorMessage.DUPLICATE_NUM.display()
            return false
        }
        return true
    }
}

enum class ValidatorMessage(val message: String) {
    INVALID_INPUT("잘못된 입력입니다."),
    DUPLICATE_NUM("중복된 번호가 존재합니다."),
    INVALID_COUNT_NUM("[ERROR] 로또 번호는 6개여야 합니다."),
    INVALID_RANGE_NUM("로또 번호의 범위는 1~45입니다.");

    fun display() {
        println("[Error] ${message}")
    }
}