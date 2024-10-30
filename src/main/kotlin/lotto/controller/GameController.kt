package lotto.controller

import lotto.model.Lotto
import lotto.view.GameView
import lotto.domain.InputValidator
import lotto.domain.GameService
import lotto.resources.Messages.*

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
        gameView.showMessage(INFO_INPUT_MONEY.message())
        val money = gameView.readLine()
        gameView.showBlankLine()

        return money.toLong()
    }

    private fun showBoughtLotto(boughtLotto: List<Lotto>) {
        gameView.showMessage(INFO_BUY_AMOUNT.formattedMessage(boughtLotto.size))
        boughtLotto.forEach {
            gameView.showMessage(it.getLottoNumbersText())
        }
        gameView.showBlankLine()
    }

    private fun readWinningNumbers(): Lotto {
        gameView.showMessage(INFO_INPUT_WINNING_NUMBER.message())
        val winningNumbersText = gameView.readLine().split(",")
        val winningNumbers = winningNumbersText.map { it.toInt() }.sorted()
        gameView.showBlankLine()

        return Lotto(winningNumbers)
    }

    private fun readBonusNumber(): Int {
        gameView.showMessage(INFO_INPUT_BONUS_NUMBER.message())
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