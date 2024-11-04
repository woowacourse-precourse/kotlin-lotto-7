package lotto.controller

import lotto.repository.Repository
import lotto.view.OutputView

class MainController (
    private val repo: Repository
) {
    private val inputController = InputController(repo)
    private val outputView = OutputView(repo)
    fun run() {
        inputController.inputPurchaseAmount()
        repo.createLottos()
        outputView.printLottos()
        inputController.inputWinningNumber()
        inputController.inputBonusNumber()
        repo.winLottery()
        outputView.printResult()
    }
}