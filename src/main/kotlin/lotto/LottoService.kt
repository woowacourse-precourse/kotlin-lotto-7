package lotto

import lotto.domain.Lotto
import lotto.domain.Money

class LottoService {
    val lottos: MutableList<Lotto> = mutableListOf()

    fun issueLottos(money: Money) {
        require(money.amount % Lotto.PRICE == 0) { ERROR_DIVISION }

        val count = money.amount / Lotto.PRICE
        repeat(count) {
            lottos.add(Lotto.create())
        }
    }

    companion object {
        const val ERROR_DIVISION = "[ERROR] 지불한 비용은 로또 가격(${Lotto.PRICE})으로 나누어 떨어져야 합니다."
    }
}
