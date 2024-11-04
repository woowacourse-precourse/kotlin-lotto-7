package lotto.model

import lotto.constants.LottoConstants
import kotlin.random.Random

class RandomLottoModel {
  private val lottoNumbers = mutableListOf<List<Int>>()

  fun generateLottoNumbers(): List<Int> {
    val numbers = (LottoConstants.LOTTO_NUMBER_MIN..LottoConstants.LOTTO_NUMBER_MAX)
      .shuffled(Random)
      .take(6)
      .sorted()
    lottoNumbers.add(numbers)
    return numbers
  }

  fun getLottoNumbers(): List<List<Int>> = lottoNumbers
}
