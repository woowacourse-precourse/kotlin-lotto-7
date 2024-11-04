package lotto.controller

import lotto.model.LottoGame
import lotto.view.InputView
import lotto.view.OutputView

class Controller {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val lottoGame = LottoGame()

    fun start() {
        buyLottoTicket()
        inputWinningNumbers()
        inputBonusBall()
        showResult()
        showRatePrize()
    }

    private fun buyLottoTicket() {
        var moneyInput: String
        var message: String?
        do {
            outputView.showPrompt(REQUEST_PURCHASE_MESSAGE)
            moneyInput = inputView.readLine()
            message = lottoGame.validateMoney(moneyInput)
            if (message is String) {
                outputView.showPrompt(message)
            }
        } while (message is String)
        lottoGame.buy(moneyInput.toInt())
        outputView.showPrompt("\n" + "${lottoGame.lottoOrder.ticketAmount}" + CONFIRM_COUNT_MESSAGE)
        lottoGame.generateLottoTickets(lottoGame.lottoOrder.ticketAmount)
    }

    private fun inputWinningNumbers() {
        var winningInput: String
        var message: String?
        do {
            outputView.showPrompt(REQUEST_WINNING_NUMBER_MESSAGE)
            winningInput = inputView.readLine()
            message = lottoGame.validateNumbers(winningInput)
            if (message is String) {
                outputView.showPrompt(message)
            }
        } while (message is String)
        lottoGame.lottoWinning.numbers = winningInput.split(SEPARATOR).map { it.toInt() }
    }

    private fun inputBonusBall() {
        var bonusInput: String
        var message: String?
        do {
            outputView.showPrompt(REQUEST_BONUS_NUMBER_MESSAGE)
            bonusInput = inputView.readLine()
            message = lottoGame.validateBonus(bonusInput)
            if (message is String) {
                outputView.showPrompt(message)
            }
        } while (message is String)
        lottoGame.lottoWinning.bonus = bonusInput.toInt()
        lottoGame.setWinnings()
    }

    private fun showResult() {
        outputView.showPrompt(TOTAL_WINNING_MESSAGE)
        lottoGame.rankings.forEach {
            outputView.showPrompt(lottoGame.getResult(it))
        }
    }

    private fun showRatePrize() {
        var totalPrize: Long = 0
        lottoGame.rankings.forEach {
            totalPrize += (it.ranking.getPrizeMoney() * it.wins)
        }
        val ratePrize = totalPrize.toDouble() / lottoGame.lottoOrder.money * 100.0
        outputView.showPrompt(PREFIX_RETURN_MESSAGE + ratePrize.toString() + SUFFIX_RETURN_MESSAGE)
    }

    companion object {
        const val SEPARATOR = ","

        const val REQUEST_PURCHASE_MESSAGE = "구입금액을 입력해 주세요."
        const val CONFIRM_COUNT_MESSAGE = "개를 구매했습니다."
        const val REQUEST_WINNING_NUMBER_MESSAGE = "\n당첨 번호를 입력해 주세요."
        const val REQUEST_BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요."
        const val TOTAL_WINNING_MESSAGE = "\n당첨 통계\n---"
        const val FIRST_MESSAGE = "개 일치"
        const val SECOND_MESSAGE = " ("
        const val THIRD_MESSAGE = "원) - "
        const val LAST_MESSAGE = "개"
        const val BONUS_BALL_MESSAGE = ", 보너스 볼 일치"
        const val PREFIX_RETURN_MESSAGE = "총 수익률은 "
        const val SUFFIX_RETURN_MESSAGE = "%입니다."
    }
}