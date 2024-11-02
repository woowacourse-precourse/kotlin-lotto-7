package lotto.controller

import lotto.constants.ErrorConstant
import lotto.repository.Repository
import lotto.view.InputView

class MainController (
    private val inputController: InputController,
) {
    fun run() {
        inputController.inputPurchaseAmount()
        inputController.inputWinningNumber()
        inputController.inputBonusNumber()
    }
}