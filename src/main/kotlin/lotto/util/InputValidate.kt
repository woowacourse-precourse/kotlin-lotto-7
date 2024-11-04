package lotto.util

import lotto.model.Lotto

object InputValidate {
    fun checkPrice(input: String, price: Int?) {
        require(input != "") { ErrorMessages.NULL_PRICE }
        require(price != null) { ErrorMessages.NOT_INT }
        require(price >= 1000) { ErrorMessages.MINIMUM_PRICE }
    }

    fun checkMyLotto(input: String, lottoNumber: List<Int?>) {
        require(input != "") { ErrorMessages.NULL_LOTTO_NUMBER }
        require(lottoNumber.all { it != null }) { ErrorMessages.NOT_INT }
        require(lottoNumber.all { it in 1..45 }) { ErrorMessages.OUT_OF_RANGE }
        require(lottoNumber.size == 6) { ErrorMessages.INVALID_NUMBER_SIZE }
        require(lottoNumber.distinct().size == lottoNumber.size) { ErrorMessages.DUPLICATE_NUMBERS }
    }

    fun checkMyBonus(input: String, bonusNumber: Int?, myLotto: Lotto) {
        require(input != "") { ErrorMessages.NULL_BONUS_NUMBER }
        require(bonusNumber != null) { ErrorMessages.NOT_INT }
        require(bonusNumber in 1..45) { ErrorMessages.OUT_OF_RANGE }
        require(bonusNumber !in myLotto.getNumbers()) { ErrorMessages.DUPLICATED_BONUS }
    }
}