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

        val winNumbers = readWinNumbers()
        val bonusNumber = readBonusNumber(winNumbers)
        val winningCounts = gameService.countWinnings(boughtLottos, winNumbers, bonusNumber)
        showLottoResult(winningCounts, money)
    }

    private fun readMoney(): Long {
        gameView.showMessage(INFO_INPUT_MONEY.message())
        while (true) {
            try {
                val money = validator.validateMoney(gameView.readLine())
                gameView.showBlankLine()
                return money
            } catch (e: IllegalArgumentException) {
                gameView.showMessage(e.message ?: INVALID_ERROR.errorMessage())
            }
        }
    }

    private fun showBoughtLotto(boughtLotto: List<Lotto>) {
        gameView.showMessage(INFO_BUY_AMOUNT.formattedMessage(boughtLotto.size))
        gameView.showMessage(boughtLotto.joinToString(separator = " \n") { it.numbersText() })
        gameView.showBlankLine()
    }

    private fun readWinNumbers(): Lotto {
        gameView.showMessage(INFO_INPUT_WINNING_NUMBER.message())
        while (true) {
            try {
                val winNumbers = validator.validateWinNumbers(gameView.readLine())
                gameView.showBlankLine()
                return winNumbers
            } catch (e: IllegalArgumentException) {
                gameView.showMessage(e.message ?: INVALID_ERROR.errorMessage())
            }
        }
    }

    private fun readBonusNumber(winNumbers: Lotto): Int {
        gameView.showMessage(INFO_INPUT_BONUS_NUMBER.message())
        while (true) {
            try {
                val bonusNumber = validator.validateBonusNumber(gameView.readLine(), winNumbers)
                gameView.showBlankLine()
                return bonusNumber
            } catch (e: IllegalArgumentException) {
                gameView.showMessage(e.message ?: INVALID_ERROR.errorMessage())
            }
        }
    }

    private fun showLottoResult(winningCounts: WinningCounter, money: Long) {
        gameView.showMessage(
            INFO_WINNING_STATISTICS.formattedMessage(*winningCounts.inOrderNumbers().toTypedArray())
        )
        showReturnRate(winningCounts, money)
    }

    private fun showReturnRate(winningCounts: WinningCounter, money: Long) {
        val returnRate = gameService.calculateReturnRate(winningCounts, money)
        gameView.showMessage(INFO_RETURN_RATE.formattedMessage(returnRate))
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