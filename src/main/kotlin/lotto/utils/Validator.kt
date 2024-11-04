package lotto.utils

import lotto.constants.LottoConstants

object Validator {

  fun validateLottoNumbers(numbers: List<Int>) {
    require(numbers.size == 6) { LottoConstants.ERROR_LOTTO_SIZE }
    require(numbers.distinct().size == 6) { LottoConstants.ERROR_DUPLICATE_NUMBER }
    require(numbers.all { it in LottoConstants.LOTTO_NUMBER_MIN..LottoConstants.LOTTO_NUMBER_MAX }) {
      LottoConstants.ERROR_INVALID_NUMBER_RANGE
    }
  }
}