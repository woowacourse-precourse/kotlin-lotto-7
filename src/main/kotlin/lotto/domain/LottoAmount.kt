package lotto.domain

import lotto.constants.LottoConstants.LOTTO_PRICE

class LottoAmount(purchasePrice: String) {
    val purchaseCount = purchasePrice.toInt() / LOTTO_PRICE
    val lottos = List(purchaseCount) { Lotto(getLottoNumbers()) }
}
