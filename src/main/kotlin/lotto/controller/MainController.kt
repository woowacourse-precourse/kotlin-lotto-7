package lotto.controller

import lotto.model.LottoTicket
import lotto.model.RandomLottoNumberGenerator
import lotto.view.InputView
import lotto.view.OutputView

class MainController {
    private val inputView = InputView()
    private val outputView = OutputView()
    private var purchaseAmount = 0
    private val lottoTicket = LottoTicket()
    private val lottoNumberGenerator = RandomLottoNumberGenerator()
    private val lottoPurchaseController = LottoPurchaseController(lottoTicket, lottoNumberGenerator)
    private var winningNumbers = listOf<Int?>()
    private var bonusNumber = 0

    fun run() {
        // 로또 구매
        outputView.printPurchaseAmountPrompt()
        purchaseAmount = inputView.inputPurchaseAmount()

        lottoPurchaseController.calculateNumberOfPurchase(purchaseAmount)
        outputView.printNumberOfPurchase(lottoTicket.numberOfPurchase)

        // 구매한 로또 저장 및 출력
        lottoPurchaseController.saveUserLottoNumbers()
        outputView.printUserLottoNumbers(lottoTicket.userLottoNumbers)

        // 당첨 번호 입력
        outputView.printWinningNumbersPrompt()
        winningNumbers = inputView.inputWinningNumbers()

        // 보너스 번호 입력
        outputView.printBonusNumberPrompt()
        bonusNumber = inputView.inputBonusNumber()

    }

}