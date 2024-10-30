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
        val winningNumbers = readWinningNumbers()
        val bonusNumber = readBonusNumber()
    }

    private fun readMoney(): Long {
        gameView.showMessage(Messages.INFO_INPUT_MONEY)
        val money = gameView.readLine()
        gameView.showBlankLine()

        return money.toLong()
    }

    private fun showBoughtLotto(boughtLotto: List<Lotto>){
        gameView.showMessage(Messages.INFO_BUY_AMOUNT.format(boughtLotto.size))
        boughtLotto.forEach {
            gameView.showMessage(it.getLottoNumbersText())
        }
        gameView.showBlankLine()
    }

    private fun readWinningNumbers(): Lotto {
        gameView.showMessage(Messages.INFO_INPUT_WINNING_NUMBER)
        val winningNumbersText = gameView.readLine().split(",")
        val winningNumbers = winningNumbersText.map { it.toInt() }.sorted()
        gameView.showBlankLine()

        return Lotto(winningNumbers)
    }

    private fun readBonusNumber(): Int {
        gameView.showMessage(Messages.INFO_INPUT_BONUS_NUMBER)
        val bonusNumber = gameView.readLine().toInt()
        gameView.showBlankLine()

        return bonusNumber
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