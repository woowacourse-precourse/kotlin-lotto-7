package lotto


enum class MoneyValidator(val msg: String) {
    ERROR_EMPTY_MONEY("[ERROR] 돈은 공백이거나 빈 값일 수 없습니다."),
    ERROR_MINUS_MONEY("[ERROR] 돈은 음수의 값을 가질 수 없습니다."),
    ERROR_NOT_NUMBER("[ERROR] 돈은 숫자만 입력하실 수 있습니다."),
    ERROR_NOT_DIVIDE_UP_1000("[ERROR] 1000으로 나누어 떨어지는 숫자만 가능합니다.")
}

enum class WinLotteryValidator(val msg: String) {
    ERROR_EMPTY_LOTTO_NUMBER("[ERROR] 복권 번호는 공백이거나 빈 값일 수 없습니다."),
    ERROR_OUT_OF_RANGE("[ERROR] 1~45 사이의 숫자만 입력 가능합니다."),
    ERROR_NOT_NUMBER("[ERROR] 복권 번호는 숫자만 입력하실 수 있습니다."),
    ERROR_INVALID_DELIMITER("[ERROR] 유효하지 않은 구분자 입니다. 복권 번호 구분자는 , 만 사용 가능합니다. "),
    ERROR_CONSECUTIVE_DELIMITER("[ERROR] 구분자가 연이어 사용했습니다. 복권 번호 구분자(,)를 하나씩 사용하세요. "),
    ERROR_TOO_MANY_LOTTO_NUMBER("[ERROR] 복권 번호는 6개까지만 입력 가능합니다.")
}

object Validator {
    fun validatePurchaseMoney(s: String) {
        require(s.isNotBlank()) {
            MoneyValidator.ERROR_EMPTY_MONEY.msg
        }
        require(s.toIntOrNull() != null) {
            MoneyValidator.ERROR_NOT_NUMBER.msg
        }
        require(s.toInt() >= 0) {
            MoneyValidator.ERROR_MINUS_MONEY.msg
        }
        require(s.toInt() % 1_000 == 0) {
            MoneyValidator.ERROR_NOT_DIVIDE_UP_1000.msg
        }
    }

    fun validateWinLottery(s: String) {
        require(s.isNotBlank()) {
            WinLotteryValidator.ERROR_EMPTY_LOTTO_NUMBER.msg
        }
        require(isContainsInvalidCharacters(s)) {
            WinLotteryValidator.ERROR_INVALID_DELIMITER.msg
        }
        require(isContainsConsecutiveCommas(s)) {
            WinLotteryValidator.ERROR_CONSECUTIVE_DELIMITER.msg
        }
        require(isChangeToInt(s)) {
            WinLotteryValidator.ERROR_NOT_NUMBER.msg
        }
        require(isOutOfRange(s)) {
            WinLotteryValidator.ERROR_OUT_OF_RANGE.msg
        }

    }

    private fun isContainsInvalidCharacters(input: String): Boolean {
        val regex = "[,]".toRegex()
        return regex.containsMatchIn(input)
    }
    private fun isContainsConsecutiveCommas(input: String): Boolean {
        val regex = ",{2,}".toRegex()
        return !regex.containsMatchIn(input)
    }

    private fun isOutOfRange(input: String): Boolean {
        val lotto = input.split(",").map { it.trim().toInt() }
        for (i in lotto) {
            if (i !in 1..45) return false
        }
        return true
    }

    private fun isChangeToInt(input: String): Boolean {
        val lotto = input.split(",").map { it.trim().toIntOrNull()}
        println("lotto: $lotto")
        for (i in lotto) {
            if (i == null) return false
        }
        return true
    }

}