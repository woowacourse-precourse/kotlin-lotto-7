package lotto.model

import lotto.global.Error
import lotto.global.LOTTO_PRICE
import lotto.utils.LottoMachine

class LottoSeller(private val money: Int) {
    init {
        require(money >= LOTTO_PRICE) { Error.BELOW_MINIMUM_AMOUNT.message }
        require(money % LOTTO_PRICE == 0) { Error.NOT_THOUSAND_UNIT.message }
    }

    val lottoCount: Int
        get() = money / LOTTO_PRICE

    fun sell(): List<Lotto> {
        return (1..lottoCount).map { LottoMachine.generate() }
    }
}