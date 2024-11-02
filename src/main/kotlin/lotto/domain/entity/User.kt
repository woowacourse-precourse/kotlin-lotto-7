package lotto.domain.entity

import lotto.common.LOTTO_PRICE
import lotto.domain.validator.PurchasePriceValidator

class User(
    private val money: Int,
    validator: PurchasePriceValidator = purchasePriceValidator
) {
    private var lottoTickets: List<Lotto>? = null

    init {
        validator.validateMoney(money)
    }

    fun buyLottoTickets(lottoTickets: (Int) -> List<Lotto>) {
        val lottoCount = money.div(LOTTO_PRICE)
        this.lottoTickets = lottoTickets(lottoCount)
    }

    fun getLottoTickets(): List<Lotto> {
        return checkNotNull(lottoTickets) { println("[ERROR] 사용자의 로또 티켓들이 아직 초기화 되지 않았습니다.") }
    }

    companion object {
        private val purchasePriceValidator by lazy { PurchasePriceValidator() }
    }
}