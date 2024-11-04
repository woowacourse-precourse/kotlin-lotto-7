package lotto.domain.factory

import lotto.Lotto
import lotto.domain.random.LottoNumberGenerator

class LottoFactory(
    private val lottoNumberGenerator: LottoNumberGenerator
) {
    fun createLottoes(amount: Int): List<Lotto> = List(amount) {
        val lottoNumbers = lottoNumberGenerator.pickLottoNumbers()
        Lotto(lottoNumbers)
    }
}
