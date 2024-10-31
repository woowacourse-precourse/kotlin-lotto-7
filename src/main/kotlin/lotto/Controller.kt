package lotto

import lotto.view.InputView
import lotto.view.OutputView
import lotto.model.LottoGenerator
import lotto.model.VerifyPrize

class Controller {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun start() {
        val tickets = payment()
        val verifyPrize = VerifyPrize()
        val earningValue = verifyPrize.prizeResult(
            purchaseLotto(tickets),
            getPrizeNumber(),
            getBonusNumber()
        )
        outputView.printResult(verifyPrize.countPrize, earningValue)
    }

    private fun payment(): Int {
        outputView.printRequirePaymentMessage()
        val tickets = inputView.amountTickets()
        outputView.printAmountTickets(tickets)
        return tickets
    }

    private fun purchaseLotto(tickets: Int) = LottoGenerator(tickets).let { lottoGenerator ->
        val lotto = lottoGenerator.purchaseLotto()
        outputView.printInformationLotto(lotto)
        lotto
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