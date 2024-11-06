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
        val validBonusNumber = number.toIntOrNull() ?: throw IllegalArgumentException(ErrorMessage.BONUS_NUMBER_INVALID_FORMAT)
        require(validBonusNumber in LottoGenerator.LOTTO_START_INCLUSIVE_NUMBER..LottoGenerator.LOTTO_END_INCLUSIVE_NUMBER ) {
            ErrorMessage.BONUS_NUMBER_NOT_IN_RANGE
        }
        require(validBonusNumber !in winningNumbers) {
            ErrorMessage.BONUS_NUMBER_OVERLAP
        }
    }

}