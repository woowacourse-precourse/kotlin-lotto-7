package lotto.controller

import lotto.model.Lotto
import lotto.view.GameView
import lotto.domain.InputValidator
import lotto.domain.GameService
import lotto.model.WinningCounter
import lotto.resources.Messages.*

class GameController(
    private val gameView: GameView,
    private val validator: InputValidator,
    private val gameService: GameService
) {
    fun gameStart() {
        val money = readMoney()
        val boughtLottos = gameService.buyLottos(money)
        showBoughtLotto(boughtLottos)

        val winNumberLotto = readWinNumbers()
        val bonusNumber = readBonusNumber()
        val winningCounts = gameService.countWinnings(boughtLottos, winNumberLotto, bonusNumber)
        showLottoResult(winningCounts)
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
            gameView.showMessage(it.numbersText())
        }
        gameView.showBlankLine()
    }

    private fun readWinNumbers(): Lotto {
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

    private fun showLottoResult(winningCounts: WinningCounter) {
        gameView.showMessage(
            INFO_WINNING_STATISTICS.formattedMessage(*winningCounts.inOrderNumbers().toTypedArray())
        )
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