package lotto.controller

import lotto.repository.Repository

class MainController (
    private val repo: Repository
) {
    private val inputController = InputController(repo)
    fun run() {
        inputController.inputPurchaseAmount()
        repo.createLottos()
        inputController.inputWinningNumber()
        inputController.inputBonusNumber()
    }
}