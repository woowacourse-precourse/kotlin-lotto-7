package template.controller

import lotto.model.Lotto
import template.view.GameView
import template.domain.InputValidator
import template.domain.GameService
import template.resources.Messages

class GameController(
    private val gameView: GameView,
    private val validator: InputValidator,
    private val gameService: GameService
) {
    fun gameStart() {
        val money = readMoney()
        val boughtLotto = gameService.buyLotto(money)
        showBoughtLotto(boughtLotto)
    }

    private fun readMoney(): Long {
        gameView.showMessage(Messages.INFO_INPUT_MONEY)
        val money = gameView.readLine()
        gameView.showBlankLine()

        return money.toLong()
    }

    private fun showBoughtLotto(ownLotto : List<Lotto>){
        gameView.showMessage(Messages.INFO_BUY_AMOUNT.format(ownLotto.size))
        ownLotto.forEach {
            gameView.showMessage(it.getLottoNumbersText())
        }
        gameView.showBlankLine()
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