package lotto

import lotto.view.InputView
import lotto.view.OutputView
import lotto.model.LottoGenerator

class Controller {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val lottoGenerator = LottoGenerator()

    fun start() {
        outputView.printRequirePaymentMessage()
        val tickets = inputView.amountTickets()
        outputView.printAmountTickets(tickets)
        val lotto = lottoGenerator.purchaseLotto(tickets)
        outputView.printInformationLotto(lotto)
        outputView.printRequirePrizeNumber()
    }
}