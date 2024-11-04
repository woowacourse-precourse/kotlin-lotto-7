package lotto.controller

import lotto.parser.Parser
import lotto.validator.Validator
import lotto.view.InputView

class LottoController {
    private val validator = Validator()
    private val parser = Parser()
    private val inputView = InputView(validator, parser)

    fun start() {
        val purchaseAmount = inputView.inputPurchaseAmount()

    }
}