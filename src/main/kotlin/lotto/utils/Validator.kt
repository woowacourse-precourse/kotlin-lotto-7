package lotto.utils

import lotto.constants.LottoConstants

object Validator {

  fun validateLottoNumbers(numbers: List<Int>) {
    require(numbers.size == 6) { showError(LottoConstants.ERROR_LOTTO_SIZE) }
    require(numbers.distinct().size == 6) { showError(LottoConstants.ERROR_DUPLICATE_NUMBER) }
    require(numbers.all { it in LottoConstants.LOTTO_NUMBER_MIN..LottoConstants.LOTTO_NUMBER_MAX }) {
      showError(LottoConstants.ERROR_INVALID_NUMBER_RANGE)
    }
  }

  fun validatePurchaseAmount(amount: Int?) {
    require(amount != null && amount % LottoConstants.LOTTO_PRICE == 0) {
      showError(LottoConstants.ERROR_INVALID_PURCHASE_AMOUNT)
    }
  }

  fun validateBonusNumber(winningNumbers: List<Int>, bonusNumber: Int?) {
    require(bonusNumber != null) { showError(LottoConstants.ERROR_INVALID_BONUS_NUMBER) }
    require(bonusNumber !in winningNumbers) { showError(LottoConstants.ERROR_DUPLICATE_NUMBER) }
    require(bonusNumber in LottoConstants.LOTTO_NUMBER_MIN..LottoConstants.LOTTO_NUMBER_MAX) {
      showError(LottoConstants.ERROR_INVALID_NUMBER_RANGE)
    }
  }

  private fun showError(message: String): Nothing {
    println("[ERROR] $message")
    throw IllegalArgumentException(message)
  }
}
