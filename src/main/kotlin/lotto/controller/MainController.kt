package lotto.controller

import lotto.model.LottoTicket
import lotto.view.InputView
import lotto.view.OutputView

class MainController {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val lottoTicket = LottoTicket()
    private val lottoPurchaseController = LottoPurchaseController(lottoTicket)

    fun run() {
        // 로또 구매
        outputView.printPurchaseAmountPrompt()
        val purchaseAmount = inputView.inputPurchaseAmount()

        lottoPurchaseController.calculateNumberOfPurchase(purchaseAmount)
        outputView.printNumberOfPurchase(lottoTicket.numberOfPurchase)

    }

}