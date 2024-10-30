package lotto.controller

import lotto.model.LottoTicket
import lotto.model.RandomLottoNumberGenerator
import lotto.view.InputView
import lotto.view.OutputView

class MainController {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val lottoTicket = LottoTicket()
    private val lottoNumberGenerator = RandomLottoNumberGenerator()
    private val lottoPurchaseController = LottoPurchaseController(lottoTicket, lottoNumberGenerator)

    fun run() {
        // 로또 구매
        outputView.printPurchaseAmountPrompt()
        val purchaseAmount = inputView.inputPurchaseAmount()

        lottoPurchaseController.calculateNumberOfPurchase(purchaseAmount)
        outputView.printNumberOfPurchase(lottoTicket.numberOfPurchase)

        // 구매한 로또 저장 및 출력
        lottoPurchaseController.saveUserLottoNumbers()
        outputView.printUserLottoNumbers(lottoTicket.userLottoNumbers)
    }

}