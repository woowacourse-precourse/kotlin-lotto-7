package lotto

import lotto.Constants.ERROR_DIVIDE_LOTTO_PURCHASE_MESSAGE
import lotto.Constants.ERROR_DUPLICATED_BONUS_NUMBER_MESSAGE
import lotto.Constants.ERROR_DUPLICATED_NUMBER_MESSAGE
import lotto.Constants.ERROR_EMPTY_LOTTO_PURCHASE_MESSAGE
import lotto.Constants.ERROR_INVALID_LOTTO_PURCHASE_MESSAGE
import lotto.Constants.ERROR_INVALID_NUMBER_COUNT_MESSAGE
import lotto.Constants.ERROR_INVALID_NUMBER_RANGE_MESSAGE
import lotto.Constants.ERROR_NEGATIVE_LOTTO_PURCHASE_MESSAGE

class Validator {
    fun checkLottoNumber(numbers: List<Int>) {
        checkLottoNumberCount(numbers)
        checkLottoNumberRange(numbers)
        checkDuplicatedLottoNumber(numbers)
    }

    fun checkLottoPurchaseAmount(purchaseAmount: String) {
        checkLottoPurchaseEmpty(purchaseAmount)
        checkNegativeLottoPurchase(purchaseAmount)
        checkLottoPurchaseDivide(purchaseAmount)
        checkLottoPurchaseNumeric(purchaseAmount)
    }

    fun checkBonusNumber(bonusNumber: String, winningNumbers: List<Int>) {
        checkBonusNumberNumeric(bonusNumber)
        checkBonusNumberRange(bonusNumber)
        checkDuplicatedBonusNumber(bonusNumber, winningNumbers)
    }

    private fun checkLottoNumberCount(numbers: List<Int>) {
        require(numbers.size == 6) { ERROR_INVALID_NUMBER_COUNT_MESSAGE }
    }

    private fun checkLottoNumberRange(numbers: List<Int>) {
        numbers.forEach { number ->
            require(number in 1..45) { ERROR_INVALID_NUMBER_RANGE_MESSAGE }
        }
    }

    private fun checkDuplicatedLottoNumber(numbers: List<Int>) {
        require(numbers.toSet().size == numbers.size) { ERROR_DUPLICATED_NUMBER_MESSAGE }
    }

    private fun checkLottoPurchaseEmpty(purchaseAmount: String) {
        require(purchaseAmount.isNotEmpty()) { ERROR_EMPTY_LOTTO_PURCHASE_MESSAGE }
    }

    private fun checkNegativeLottoPurchase(purchaseAmount: String) {
        require(purchaseAmount.toInt() > 0) { ERROR_NEGATIVE_LOTTO_PURCHASE_MESSAGE }
    }

    private fun checkLottoPurchaseDivide(purchaseAmount: String) {
        require(purchaseAmount.toInt() % 1000 == 0) { ERROR_DIVIDE_LOTTO_PURCHASE_MESSAGE }
    }

    private fun checkLottoPurchaseNumeric(purchaseAmount: String) {
        require(!isNumeric(purchaseAmount)) { ERROR_INVALID_LOTTO_PURCHASE_MESSAGE }
    }

    private fun checkBonusNumberNumeric(bonusNumber: String) {
        require(!isNumeric(bonusNumber)) { ERROR_INVALID_LOTTO_PURCHASE_MESSAGE }
    }

    private fun checkBonusNumberRange(bonusNumber: String) {
        require(bonusNumber.toInt() in 1..45) { ERROR_INVALID_NUMBER_RANGE_MESSAGE }
    }

    private fun checkDuplicatedBonusNumber(bonusNumber: String, winningNumbers: List<Int>) {
        require(!winningNumbers.contains(bonusNumber.toInt())) { ERROR_DUPLICATED_BONUS_NUMBER_MESSAGE }
    }

    private fun isNumeric(number: String): Boolean {
        return number.toIntOrNull() == null
    }
}