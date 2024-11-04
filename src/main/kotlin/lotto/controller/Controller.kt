package lotto.controller

import lotto.model.LottoGame
import lotto.model.Rank
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
        lottoGame.setWinnings()
        getResult()
    }

    private fun buyLottoTicket() {
        var moneyInput: String
        var message: String?
        do {
            outputView.showPrompt(REQUEST_PURCHASE_MESSAGE)
            moneyInput = inputView.readLine()
            message = lottoGame.isValidMoney(moneyInput)
            if (message is String) {
                outputView.showPrompt(message)
            }
        } while (message is String)
        lottoGame.buy(moneyInput.toInt())
        outputView.showPrompt("\n" + "${lottoGame.lottoOrder.totalTicket}" + CONFIRM_COUNT_MESSAGE)
        lottoGame.generateLottoTickets(lottoGame.lottoOrder.totalTicket)
    }

    private fun inputWinningNumbers() {
        var winningInput: String
        var message: String?
        do {
            outputView.showPrompt(REQUEST_WINNING_NUMBER_MESSAGE)
            winningInput = inputView.readLine()
            message = lottoGame.isValidNumbers(winningInput)
            if (message is String) {
                outputView.showPrompt(message)
            }
        } while (message is String)
        lottoGame.lottoWinning.numbers = winningInput.split(",").map { it.toInt() }
    }

    private fun inputBonusBall() {
        var bonusInput: String
        var message: String?
        do {
            outputView.showPrompt(REQUEST_BONUS_NUMBER_MESSAGE)
            bonusInput = inputView.readLine()
            message = lottoGame.isValidBonus(bonusInput)
            if (message is String) {
                outputView.showPrompt(message)
            }
        } while (message is String)
        lottoGame.lottoWinning.bonus = bonusInput.toInt()
    }

    fun getResult() {
        outputView.showPrompt(TOTAL_WINNING_MESSAGE)
        lottoGame.rankings.forEach {
            showResult(it)
        }
        getRatePrize(getTotalPrize())
    }

    private fun formatMoney(money: Int): String {
        var formated = ""
        val moneyString = money.toString()
        val num = moneyString.length % 3 - 1
        for (index in moneyString.indices) {
            formated += moneyString[index]
            if (index % 3 == num && index != moneyString.length - 1) {
                formated += SEPARATOR
            }
        }
        return formated
    }

    fun showResult(ranking: Rank) {
        var result = "${ranking.ranking.getWinningBall()}" + FIRST_MESSAGE
        if (ranking.ranking.getWinningBall() == 5 && ranking.ranking.getBonusBall()) {
            result += BONUS_BALL_MESSAGE
        }
        result += SECOND_MESSAGE + formatMoney(ranking.ranking.getPrizeMoney()) + THIRD_MESSAGE + ranking.wins + LAST_MESSAGE
        outputView.showPrompt(result)
    }

    private fun getTotalPrize(): Long {
        var totalPrize: Long = 0
        lottoGame.rankings.forEach {
            totalPrize += (it.ranking.getPrizeMoney() * it.wins)
        }
        println(totalPrize)
        return totalPrize
    }

    fun getRatePrize(totalPrize: Long) {
        val ratePrize = totalPrize.toDouble() / lottoGame.lottoOrder.totalPrice * 100.0
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