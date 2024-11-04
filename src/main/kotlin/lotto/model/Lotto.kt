package lotto.model

import lotto.constants.LottoConstants
import lotto.utils.Validator
import kotlin.random.Random

class Lotto(private val numbers: List<Int> = generateLottoNumbers()) {

  init {
    Validator.validateLottoNumbers(numbers)
  }

  fun getNumbers(): List<Int> = numbers

  companion object {
    private fun generateLottoNumbers() =
      (LottoConstants.LOTTO_NUMBER_MIN..LottoConstants.LOTTO_NUMBER_MAX)
        .shuffled(Random)
        .take(6)
        .sorted()
  }
}
