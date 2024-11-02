package lotto

import lotto.domain.usecase.CalculateLottoRankUseCase
import lotto.domain.usecase.CalculateLottoReturnUseCase
import lotto.domain.usecase.CreateUserUseCase
import lotto.domain.usecase.CreateWinningNumbersUseCase
import lotto.ui.view.LottoBuyView
import lotto.ui.controller.LottoController
import lotto.ui.view.LottoResultView
import lotto.ui.view.WinningNumberInputView

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
