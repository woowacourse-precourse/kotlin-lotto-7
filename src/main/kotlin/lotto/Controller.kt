package lotto

import lotto.model.LottoGenerator
import lotto.model.VerifyPrize
import lotto.view.InputView
import lotto.view.OutputView

class Controller {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun start() {
        val tickets = payment()
        val verifyPrize = VerifyPrize()
        val earningValue = verifyPrize.prizeResult(purchaseLotto(tickets), prizeNumber(), bonusNumber())
        outputView.printResult(verifyPrize.countPrize, earningValue)
    }

    private fun payment(): Int {
        outputView.printRequirePaymentMessage()
        val tickets = inputView.amountTickets()
        outputView.printAmountTickets(tickets)
        return tickets
    }

    private fun purchaseLotto(tickets: Int): List<List<Int>> {
        val lottoGenerator = LottoGenerator(tickets)
        val lotto = lottoGenerator.purchaseLotto()
        outputView.printInformationLotto(lotto)
        return lotto
    }

    private fun prizeNumber(): List<Int> {
        outputView.printRequirePrizeNumber()
        return inputView.getPrizeNumber()
    }

    private fun bonusNumber(): Int {
        outputView.printRequireBonusNumber()
        return inputView.getBonusNumber()
    }
}