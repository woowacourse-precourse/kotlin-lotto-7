package lotto

import lotto.di.AppContainer
import lotto.ui.view.LottoBuyView
import lotto.ui.controller.LottoController
import lotto.ui.view.LottoResultView
import lotto.ui.view.WinningNumbersInputView

fun main() {
    val appContainer = AppContainer()
    val lottoBuyView = LottoBuyView()
    val winningNumbersInputView = WinningNumbersInputView()
    val lottoResultView = LottoResultView()
    LottoController(
        appContainer,
        lottoBuyView,
        winningNumbersInputView,
        lottoResultView
    ).run()
}
