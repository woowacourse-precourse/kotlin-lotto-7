package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.constants.LottoConstants
import lotto.utils.Validator

class Lotto(private val numbers: List<Int> = generateLottoNumbers()) {

  init {
    Validator.validateLottoNumbers(numbers)
  }

  fun getNumbers(): List<Int> = numbers

  companion object {
    private fun generateLottoNumbers(): List<Int> =
      Randoms.pickUniqueNumbersInRange(
        LottoConstants.LOTTO_NUMBER_MIN,
        LottoConstants.LOTTO_NUMBER_MAX,
        6
      ).sorted()
  }
}
