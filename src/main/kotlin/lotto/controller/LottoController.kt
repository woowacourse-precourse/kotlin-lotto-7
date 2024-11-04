package lotto.controller

import lotto.view.LottoView
import lotto.model.LottoPurchaseAmount
import lotto.model.LottoStore

class LottoController(private val lottoView: LottoView) {
    fun run() {
        val lottoPurchaseAmount = payMoney()
        val lottos = purchaseLottos(lottoPurchaseAmount.money)
    }

    private fun payMoney(): LottoPurchaseAmount {
        return try {
            lottoView.printLottoPurchaseRequest()
            LottoPurchaseAmount.from(lottoView.inputLottoPurchaseAmount())
        } catch (e: IllegalArgumentException) {
            lottoView.printError(e.message)
            return payMoney()
        }
    }

    private fun purchaseLottos(money: Int): List<Lotto> {
        val lottoCount = money / LottoStore.LOTTO_TICKET_PRICE
        val lottos = mutableListOf<Lotto>()
        lottoView.printLottoCount(lottoCount)
        repeat(lottoCount) { lottos.add(Lotto.fromList(LottoStore().buy())) }
        lottoView.printLottos(lottos)
        return lottos
    }


}

