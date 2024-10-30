package lotto

import lotto.view.InputView
import lotto.view.OutputView
import lotto.model.LottoGenerator

class Controller {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val lottoGenerator = LottoGenerator()

    fun start() {
        val tickets = payment()
        purchaseLotto(tickets)
        getPrizeNumber()
        getBonusNumber()
    }

    private fun payment(): Int {
        outputView.printRequirePaymentMessage()
        val tickets = inputView.amountTickets()
        outputView.printAmountTickets(tickets)
        return tickets
    }

    private fun purchaseLotto(tickets: Int): List<List<Int>> {
        val lotto = lottoGenerator.purchaseLotto(tickets)
        outputView.printInformationLotto(lotto)
        return lotto
    }

    private fun getPrizeNumber(): List<Int> {
        outputView.printRequirePrizeNumber()
        return inputView.inputPrizeNumber()
    }

    private fun getBonusNumber(): Int {
        outputView.printRequireBonusNumber()
        return inputView.inputBonusNumber()
    }
}