package lotto.domain.model.factory

import lotto.domain.model.Lotto
import lotto.domain.random.LottoNumberGenerator

class LottoFactory(
    private val lottoNumberGenerator: LottoNumberGenerator
) {
    fun createLottoes(amount: Int): List<Lotto> = List(amount) {
        val lottoNumbers = lottoNumberGenerator.pickLottoNumbers()
        Lotto(lottoNumbers)
    }
}
