package lotto

import lotto.Constants.ERROR_EMPTY_LOTTO_PURCHASE_MESSAGE
import lotto.Constants.ERROR_INVALID_LOTTO_PURCHASE_MESSAGE
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
        checkLottoPurchaseNumeric(purchaseAmount)
    }

    private fun checkLottoNumberCount(numbers: List<Int>) {
        require(numbers.size == 6) { Constants.ERROR_INVALID_NUMBER_COUNT_MESSAGE }
    }

    private fun checkLottoNumberRange(numbers: List<Int>) {
        numbers.forEach { number ->
            require(number in 1..45) { Constants.ERROR_INVALID_NUMBER_RANGE_MESSAGE }
        }
    }

    private fun checkDuplicatedLottoNumber(numbers: List<Int>) {
        require(numbers.toSet().size == numbers.size) { Constants.ERROR_DUPLICATED_NUMBER_MESSAGE }
    }

    private fun checkLottoPurchaseEmpty(purchaseAmount: String) {
        require(purchaseAmount.isNotEmpty()) { ERROR_EMPTY_LOTTO_PURCHASE_MESSAGE }
    }

    private fun checkNegativeLottoPurchase(purchaseAmount: String) {
        require(purchaseAmount.toInt() > 0) { ERROR_NEGATIVE_LOTTO_PURCHASE_MESSAGE }
    }

    private fun checkLottoPurchaseNumeric(purchaseAmount: String) {
        require(!isNumeric(purchaseAmount)) { ERROR_INVALID_LOTTO_PURCHASE_MESSAGE }
    }

    private fun isNumeric(number: String): Boolean {
        return number.toIntOrNull() != null
    }
}