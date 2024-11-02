package lotto.controller

import lotto.model.Lotto
import lotto.view.GameView
import lotto.domain.InputService
import lotto.domain.GameService
import lotto.model.WinningCounter
import lotto.resources.Messages.*

class GameController(
    private val gameView: GameView,
    private val inputService: InputService,
    private val gameService: GameService
) {
    fun gameStart() {
        val money = readMoney()
        val boughtLottos = gameService.buyLottos(money)
        showBoughtLotto(boughtLottos)

        val winningCounts = checkWinningStatus(boughtLottos)
        showLottoResult(winningCounts, money)
    }

    private fun readMoney(): Long {
        return inputService.readValidInput(INFO_INPUT_MONEY.message()) { input ->
            inputService.validateMoney(input)
        }
    }

    private fun showBoughtLotto(boughtLotto: List<Lotto>) {
        gameView.showMessage(INFO_BUY_AMOUNT.formattedMessage(boughtLotto.size))
        gameView.showMessage(boughtLotto.joinToString(separator = " \n") { it.numbersText() })
        gameView.showBlankLine()
    }

    private fun checkWinningStatus(boughtLottos: List<Lotto>): WinningCounter {
        val winNumbers = readWinNumbers()
        val bonusNumber = readBonusNumber(winNumbers)
        return gameService.countWinnings(boughtLottos, winNumbers, bonusNumber)
    }

    private fun readWinNumbers(): Lotto {
        return inputService.readValidInput(INFO_INPUT_WINNING_NUMBER.message()) { input ->
            inputService.validateWinNumbers(input)
        }
    }

    private fun readBonusNumber(winNumbers: Lotto): Int {
        return inputService.readValidInput(INFO_INPUT_BONUS_NUMBER.message()) { input ->
            inputService.validateBonusNumber(input, winNumbers)
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
            val inputService = InputService(gameView)
            val gameService = GameService()
            return GameController(gameView, inputService, gameService)
        }
    }
}