package lotto.model

import lotto.Lotto

interface LottoNumberGenerator {
    fun generateNumbers(): Lotto
}