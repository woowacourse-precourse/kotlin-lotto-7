package lotto.utils

import lotto.constants.ErrorMessage

object ValidationUtils {

    fun checkValidInputPurchaseMoney(money: String) {
        val validMoney = money.toIntOrNull() ?: throw IllegalArgumentException(ErrorMessage.PURCHASE_MONEY_INVALID_FORMAT)
        require(validMoney >= LottoGenerator.LOTTO_MONEY_MINIMUM) {
            ErrorMessage.PURCHASE_MONEY_LESS_THAN_MINIMUM
        }
        require(validMoney % LottoGenerator.LOTTO_MONEY_UNIT == 0) {
            ErrorMessage.PURCHASE_MONEY_NOT_IN_1000_UNITS
        }
        require(validMoney <= LottoGenerator.LOTTO_MONEY_MAXIMUM) {
            ErrorMessage.PURCHASE_MONEY_EXCEEDS_MAXIMUM
        }
    }

    fun checkValidLottoNumbers(numbers: List<Int>) {
        require(numbers.size == LottoGenerator.LOTTO_ONE_SET_SIZE ) {
            ErrorMessage.LOTTO_NUMBER_NOT_ONE_SET_SIZE
        }
        require(numbers.all { it in LottoGenerator.LOTTO_START_INCLUSIVE_NUMBER..LottoGenerator.LOTTO_END_INCLUSIVE_NUMBER }) {
            ErrorMessage.LOTTO_NUMBER_NOT_IN_RANGE
        }
        require(numbers.size == numbers.toSet().size) {
            ErrorMessage.LOTTO_NUMBER_OVERLAP
        }
    }

    fun checkValidWinningNumbers(numbers: String) {
        val validNumbers = numbers.split(InputManager.INPUT_WINNING_NUMBERS_SEPARATOR).map {
            it.toIntOrNull() ?: throw IllegalArgumentException(ErrorMessage.WINNING_NUMBER_INVALID_FORMAT)
        }
        require(validNumbers.size == LottoGenerator.LOTTO_ONE_SET_SIZE ) {
            ErrorMessage.WINNING_NUMBER_NOT_ONE_SET_SIZE
        }
        require(validNumbers.all { it in LottoGenerator.LOTTO_START_INCLUSIVE_NUMBER..LottoGenerator.LOTTO_END_INCLUSIVE_NUMBER }) {
            ErrorMessage.WINNING_NUMBER_NOT_IN_RANGE
        }
        require(validNumbers.size == validNumbers.toSet().size) {
            ErrorMessage.WINNING_NUMBER_OVERLAP
        }
    }

    fun checkValidBonusNumber(number: String, winningNumbers: List<Int>) {
        try {
            val validBonusNumber = number.toInt()
            require(validBonusNumber in 1..45 ) {
                "[ERROR] 보너스 번호는 1~45 사이의 정수만 가능합니다."
            }
            require(validBonusNumber !in winningNumbers) {
                "[ERROR] 보너스 번호와 당첨 번호는 중복될 수 없습니다."
            }
        } catch (e: Exception) {
            throw IllegalArgumentException("보너스 번호는 공백 없이 1~45 사이의 정수만 입력 가능합니다.")
        }
    }

}