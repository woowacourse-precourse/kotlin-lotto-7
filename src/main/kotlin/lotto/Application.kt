package lotto

import lotto.di.AppContainer
import lotto.domain.usecase.*
import lotto.ui.view.LottoBuyView
import lotto.ui.controller.LottoController
import lotto.ui.view.LottoResultView
import lotto.ui.view.WinningNumberInputView

fun main() {
    val appContainer = AppContainer()
    val lottoBuyView = LottoBuyView()
    val winningNumberInputView = WinningNumberInputView()
    val lottoResultView = LottoResultView()
    LottoController(
        appContainer,
        lottoBuyView,
        winningNumberInputView,
        lottoResultView
    ).run()
}
