package lotto

import lotto.domain.usecase.*
import lotto.ui.view.LottoBuyView
import lotto.ui.controller.LottoController
import lotto.ui.view.LottoResultView
import lotto.ui.view.WinningNumberInputView

fun main() {
    val calculateLottoRankUseCase = CalculateLottoRankUseCase()
    val calculateLottoReturnUseCase = CalculateLottoReturnUseCase()
    val createUserUseCase = CreateUserUseCase()
    val createWinningNumbersUseCase = CreateWinningNumbersUseCase()
    val createLottoUseCase = CreateLottoUseCase()
    val lottoBuyView = LottoBuyView()
    val winningNumberInputView = WinningNumberInputView()
    val lottoResultView = LottoResultView()
    LottoController(
        calculateLottoRankUseCase,
        calculateLottoReturnUseCase,
        createUserUseCase,
        createWinningNumbersUseCase,
        createLottoUseCase,
        lottoBuyView,
        winningNumberInputView,
        lottoResultView
    ).run()
}
