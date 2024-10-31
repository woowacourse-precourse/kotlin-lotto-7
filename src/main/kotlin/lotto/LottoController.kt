package lotto

class LottoController(
    private val calculateLottoRankUseCase: CalculateLottoRankUseCase,
    private val calculateLottoReturnUseCase: CalculateLottoReturnUseCase,
    private val lottoBuyView: LottoBuyView,
    private val winningNumberInputView: WinningNumberInputView,
    private val lottoResultView: LottoResultView
) {
    fun run() {
        val lottoCost = getLottoCost()

    }

    private fun getLottoCost(): String {
        lottoBuyView.guidePurchaseAmount()
        return lottoBuyView.inputPurchaseAmount()
    }
}