package lotto.validator

import lotto.constant.*

class InputValidator {

    fun isValidMoney(input: String) {
        val regex = Regex(MONEY_REGEX)
        val money = input.replace(COMMA, "").toIntOrNull()

        if (input == "") {
            throw IllegalArgumentException(ValidatorMessage.INVALID_INPUT.errorMessage())
        } else if (!regex.matches(input)) { //단위 구분을 위한 쉼표의 위치가 올바른지 확인
            throw IllegalArgumentException(ValidatorMessage.INVALID_INPUT.errorMessage())
        } else if (money == null) {
            throw IllegalArgumentException(ValidatorMessage.INVALID_INPUT.errorMessage())
        } else if (money % AMOUNT_UNIT != 0 || money <= 0) { //1,000으로 나누어 떨어지지 않는 경우
            throw IllegalArgumentException(ValidatorMessage.INVALID_INPUT.errorMessage())
        }
    }

    fun isValidWinningNum(input: String) {
        val inputNumbers = input.split(COMMA).map { it.trim() }

        if (input == "") {
            throw IllegalArgumentException(ValidatorMessage.INVALID_INPUT.errorMessage())
        } else if (inputNumbers.size != LOTTO_SIZE) { //입력된 번호가 6개가 아닌 경우
            throw IllegalArgumentException(ValidatorMessage.INVALID_COUNT_NUM.errorMessage())
        } else if (inputNumbers.size != inputNumbers.distinct().size) { // 중복된 숫자가 존재하는 경우
            throw IllegalArgumentException(ValidatorMessage.DUPLICATE_NUM.errorMessage())
        }
        inputNumbers.forEach {
            val num = it.toIntOrNull()
            if (num == null || num < MIN_LOTTO_NUM || num > MAX_LOTTO_NUM) { // 1~45 범위를 벗어난 경우
                throw IllegalArgumentException(ValidatorMessage.INVALID_RANGE_NUM.errorMessage())
            }
        }
    }

    fun isValidBonusNum(input: String, winningNum: List<Int>) {
        val num = input.toIntOrNull()

        if (num == null || num < MIN_LOTTO_NUM || num > MAX_LOTTO_NUM) { //1~45범위는 벗어난 경우
            throw IllegalArgumentException(ValidatorMessage.INVALID_RANGE_NUM.errorMessage())
        } else if (winningNum.contains(num)) { //당첨번호와 중복되는 경우
            throw IllegalArgumentException(ValidatorMessage.DUPLICATE_NUM.errorMessage())
        }
    }
}
