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

    }

    private fun readMoney(): Long {
        gameView.showMessage(Messages.INFO_INPUT_MONEY)
        val money = gameView.readLine()
        gameView.showBlankLine()

        return money.toLong()
    }

    private fun announceFinalWinner() {
        val winnersName = gameService.findWinnerNames(
            listOf(DummyModel("1호", 10), DummyModel("2호"))
        )
        gameView.showMessage("우승자 : ${winnersName.joinToString()}")
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