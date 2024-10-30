package template.controller

import template.view.GameView
import template.domain.InputValidator
import template.domain.GameService
import template.model.DummyModel
import template.resources.Messages

class GameController(
    private val gameView: GameView,
    private val validator: InputValidator,
    private val gameService: GameService
) {
    fun gameStart() {
        val money = readMoney()
        val ownLotto = gameService.buyLotto(money)
    }

    private fun readMoney(): Long {
        gameView.showMessage(Messages.INFO_INPUT_MONEY)
        val money = gameView.readLine()
        gameView.showBlankLine()

        return money.toLong()
    }

    companion object {
        fun create(): GameController {
            val gameView = GameView()
            val inputValidator = InputValidator()
            val gameService = GameService()
            return GameController(gameView, inputValidator, gameService)
        }
    }
}