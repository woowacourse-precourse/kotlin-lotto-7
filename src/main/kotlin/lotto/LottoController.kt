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
        val user = User(lottoCost.toInt())
        showLottoTicketsResult(user)
    }

    private fun getLottoCost(): String {
        lottoBuyView.guidePurchaseAmount()
        return lottoBuyView.inputPurchaseAmount()
    }

    private fun showLottoTicketsResult(user: User) {
        lottoBuyView.guidePurchaseLottoCount(user.getLottoTickets().count())
        lottoBuyView.guideLottoNumbers(user.getLottoTickets())
    }
}