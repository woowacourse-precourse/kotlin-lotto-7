package lotto

import lotto.controller.LottoController
import lotto.service.LottoService
import lotto.validator.LottoValidator
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val service = LottoService()
    val validator = LottoValidator()
    val controller = LottoController(inputView, outputView, service, validator)
    controller.run()
}
