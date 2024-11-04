package lotto

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

}

