package lotto

import lotto.view.OutputView
import lotto.controller.LottoController
import lotto.model.message.ErrorMessage
import lotto.view.ErrorView

fun main() {
    val lottoController = LottoController()

    try {
        lottoController.run()
    } catch (e: IllegalArgumentException) {
        ErrorView.errorMessage(e.message ?: ErrorMessage.DEFAULT_ERROR.message)
        throw e
    }
}
