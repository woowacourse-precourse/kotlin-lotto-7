package lotto

fun main() {
    val calculateLottoRankUseCase = CalculateLottoRankUseCase()
    val calculateLottoReturnUseCase = CalculateLottoReturnUseCase()
    val createUserUseCase = CreateUserUseCase()
    val createWinningNumbersUseCase = CreateWinningNumbersUseCase()
    val lottoBuyView = LottoBuyView()
    val winningNumberInputView = WinningNumberInputView()
    val lottoResultView = LottoResultView()
    LottoController(
        calculateLottoRankUseCase,
        calculateLottoReturnUseCase,
        createUserUseCase,
        createWinningNumbersUseCase,
        lottoBuyView,
        winningNumberInputView,
        lottoResultView
    ).run()
}
