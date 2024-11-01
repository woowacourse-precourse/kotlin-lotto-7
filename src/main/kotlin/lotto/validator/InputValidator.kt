package lotto.validator

const val MONEY_REGEX = "^\\d{1,3}(,\\d{3})*?$|^\\d+$"
const val AMOUNT_UNIT = 1000

class InputValidator {

    fun isValidMoney(input: String) {
        val regex = Regex(MONEY_REGEX)
        val money = input.replace(",", "").toIntOrNull()

        if (input == "") {
            throw IllegalArgumentException(ValidatorMessage.INVALID_INPUT.message)
        } else if (!regex.matches(input)) {
            throw IllegalArgumentException(ValidatorMessage.INVALID_INPUT.message)
        } else if (money == null) {
            throw IllegalArgumentException(ValidatorMessage.INVALID_INPUT.message)
        } else if (money % AMOUNT_UNIT != 0 || money <= 0) {
            throw IllegalArgumentException(ValidatorMessage.INVALID_INPUT.message)
        }
    }

    fun isValidWinningNum(input: String){
        val inputNumbers = input.split(",").map { it.trim() }

        if (input == "") {
            throw IllegalArgumentException(ValidatorMessage.INVALID_INPUT.message)
        } else if (inputNumbers.size != 6) {
            throw IllegalArgumentException(ValidatorMessage.INVALID_COUNT_NUM.message)
        } else if (inputNumbers.size != inputNumbers.distinct().size) {
            throw IllegalArgumentException(ValidatorMessage.DUPLICATE_NUM.message)
        }
        inputNumbers.forEach {
            val num = it.toIntOrNull()
            if (num == null || num < 1 || num > 45) {
                throw IllegalArgumentException(ValidatorMessage.INVALID_RANGE_NUM.message)
            }
        }
    }

    fun isValidBonusNum(input: String, winningNum: List<Int>) {
        val num = input.toIntOrNull()

        if (num == null || num < 1 || num > 45) {
            throw IllegalArgumentException(ValidatorMessage.INVALID_RANGE_NUM.message)
        } else if (winningNum.contains(num)) {
            throw IllegalArgumentException(ValidatorMessage.DUPLICATE_NUM.message)
        }
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