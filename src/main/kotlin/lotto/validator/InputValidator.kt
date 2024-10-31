package lotto.validator

const val MONEY_REGEX = "^\\d{1,3}(,\\d{3})*?$|^\\d+$"
const val AMOUNT_UNIT = 1000

class InputValidator {

    fun isValidMoney(input: String): Boolean {
        val regex = Regex(MONEY_REGEX)
        val money = input.replace(",", "").toIntOrNull()

        if (input == "") {
            ValidatorMessage.INVALID_MONEY.display()
            return false
        }
        else if (!regex.matches(input)) {
            ValidatorMessage.INVALID_MONEY.display()
            return false
        }
        else if (money == null) {
            ValidatorMessage.INVALID_MONEY.display()
            return false
        }
        else if (money % AMOUNT_UNIT != 0 || money <= 0) {
            ValidatorMessage.INVALID_MONEY.display()
            return false
        }

        return true
    }

    fun isValidWinningNum(input: String):Boolean{
        val inputNumbers = input.split(",").map{it.trim()}

        if(input =="") {
            ValidatorMessage.INVALID_WINNING_NUM.display()
            return false
        }
        else if(inputNumbers.size!=6) {
            ValidatorMessage.INVALID_WINNING_NUM.display()
            return false
        }
        else if(inputNumbers.size!=inputNumbers.distinct().size) {
            ValidatorMessage.DUPLICATE_WINNING_NUM.display()
            return false
        }
        inputNumbers.forEach{
            val num = it.toIntOrNull()
            if(num==null || num<1 || num>45) {
                ValidatorMessage.INVALID_RANGE_WINNING_NUM.display()
                return false
            }
        }
        return true

    }
}

enum class ValidatorMessage(val message: String) {
    INVALID_MONEY("잘못된 입력입니다."),
    INVALID_WINNING_NUM("잘못된 입력입니다."),
    DUPLICATE_WINNING_NUM("중복된 번호가 존재합니다."),
    INVALID_RANGE_WINNING_NUM("로또 번호의 범위는 1~45입니다.");

    fun display() {
        println("[Error] ${message}")
    }
}