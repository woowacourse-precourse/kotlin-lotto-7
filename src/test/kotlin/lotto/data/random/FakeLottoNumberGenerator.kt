package lotto.data.random

import lotto.domain.random.LottoNumberGenerator

class FakeLottoNumberGenerator : LottoNumberGenerator {
    var nextLottoNumbers: MutableList<List<Int>> = mutableListOf()
    val maxAmount get() = nextLottoNumbers.size

    override fun pickLottoNumbers(): List<Int> = nextLottoNumbers.removeFirst()
}
