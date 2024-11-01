package lotto

fun main() {
    val calculateLottoRankUseCase = CalculateLottoRankUseCase()
    val calculateLottoReturnUseCase = CalculateLottoReturnUseCase()
    val createUserUseCase = CreateUserUseCase()
    val lottoBuyView = LottoBuyView()
    val winningNumberInputView = WinningNumberInputView()
    val lottoResultView = LottoResultView()
    LottoController(
        calculateLottoRankUseCase,
        calculateLottoReturnUseCase,
        createUserUseCase,
        lottoBuyView,
        winningNumberInputView,
        lottoResultView
    ).run()
}
