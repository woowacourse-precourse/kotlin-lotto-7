package lotto

import lotto.controller.LottoController
import lotto.view.InputView

fun main() {
    val view = InputView()
    val controller = LottoController(view)
    controller.run()
}
