package lotto

import lotto.controller.LottoController
import lotto.view.LottoInputView
import lotto.view.LottoOutputView

fun main() {
    // TODO: 예외 발생 후에도 항상 해당 부분 부터 다시 입력을 받는다.
    val inputView = LottoInputView()
    val outputView = LottoOutputView()
    val lottoController = LottoController(inputView, outputView)

    lottoController.purchaseLotto()
    lottoController.showPurchasedLotto()
    lottoController.inputWinningNumbers()
    lottoController.inputBonusNumber()
    lottoController.showLottoResult()
}
