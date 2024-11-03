package lotto.utils

object Validator {
    fun validateLottoAmount(lottoAmount: String) {
        require(lottoAmount.toIntOrNull() != null) { Constants.ERROR_AMOUNT_NOT_NUMBER }
        val amount = lottoAmount.toInt()
        require(amount >= Constants.LOTTO_PRICE) { Constants.ERROR_AMOUNT_UNDER_1000 }
        require(amount % Constants.LOTTO_PRICE == Constants.ZERO) { Constants.ERROR_AMOUNT_NOT_DIVIDE_BY_1000 }
    }

    fun validateWinningNumbers(winningNumbers: List<String>) {
        require(winningNumbers.all { it.toIntOrNull() != null }) {
            Constants.ERROR_WINNING_NUMBERS_NOT_NUMBER
        }
        require(winningNumbers.size == Constants.LOTTO_NUMBERS_SIZE) {
            Constants.ERROR_WINNING_NUMBERS_INCORRECT_SIZE
        }
        require(winningNumbers.all { it.toInt() in Constants.LOTTO_NUMBER_MIN..Constants.LOTTO_NUMBER_MAX }) {
            Constants.ERROR_WINNING_NUMBERS_OUT_OF_RANGE
        }
        require(winningNumbers.distinct().size == winningNumbers.size) {
            Constants.ERROR_WINNING_NUMBERS_DUPLICATE
        }
    }

    fun validateBonusNumber(bonusNumber: String, winningNumbers: List<Int>) {
        require(bonusNumber.toIntOrNull() != null) { Constants.ERROR_BONUS_NUMBER_NOT_NUMBER }
        require(bonusNumber.toInt() in Constants.LOTTO_NUMBER_MIN..Constants.LOTTO_NUMBER_MAX) {
            Constants.ERROR_BONUS_NUMBER_OUT_OF_RANGE
        }
        require(bonusNumber.toInt() !in winningNumbers) { Constants.ERROR_BONUS_NUMBER_DUPLICATE }
    }
}