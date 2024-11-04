package lotto.utils

import lotto.model.Lotto

class LottoGenerator {

  fun generateLottos(count: Int): List<Lotto> {
    return List(count) { Lotto() }
  }
}
