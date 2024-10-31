package lotto

fun main() {
    val calculateLottoRankUseCase = CalculateLottoRankUseCase()
    val calculateLottoReturnUseCase = CalculateLottoReturnUseCase()
    val lottoBuyView = LottoBuyView()
    val winningNumberInputView = WinningNumberInputView()
    val lottoResultView = LottoResultView()
    LottoController(
        calculateLottoRankUseCase,
        calculateLottoReturnUseCase,
        lottoBuyView,
        winningNumberInputView,
        lottoResultView
    ).run()
}
