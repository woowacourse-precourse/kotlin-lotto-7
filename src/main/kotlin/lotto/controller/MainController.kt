package lotto.controller

import lotto.model.LottoTicket
import lotto.model.RandomLottoNumberGenerator
import lotto.model.WinningStatistics
import lotto.util.InputValidator
import lotto.view.InputView
import lotto.view.OutputView

class MainController {
    private val inputView = InputView()
    private val inputValidator = InputValidator()
    private val outputView = OutputView()
    private var purchaseAmount = 0
    private val lottoTicket = LottoTicket()
    private val lottoNumberGenerator = RandomLottoNumberGenerator()
    private val lottoPurchaseController = LottoPurchaseController(lottoTicket, lottoNumberGenerator)
    private var winningNumbers = listOf<Int?>()
    private var bonusNumber = 0
    private val winningStatistics = WinningStatistics()

    fun run() {
        // 로또 구매
        while (true) {
            try {
                outputView.printPurchaseAmountPrompt()
                val purchaseAmountInput = inputView.inputPurchaseAmount()
                inputValidator.validatePurchaseAmount(purchaseAmountInput)
                purchaseAmount = purchaseAmountInput.toInt()
                break
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
        lottoPurchaseController.calculateNumberOfPurchase(purchaseAmount)
        outputView.printNumberOfPurchase(lottoTicket.numberOfPurchase)

        // 구매한 로또 저장 및 출력
        lottoPurchaseController.saveUserLottoNumbers()
        outputView.printUserLottoNumbers(lottoTicket.userLottoNumbers)

        // 당첨 번호 입력
        while (true) {
            try {
                outputView.printWinningNumbersPrompt()
                val winningNumbersInput = inputView.inputWinningNumbers()
                val parsedWinningNumbers = winningNumbersInput.split(",").map { it.trim().toIntOrNull() }
                inputValidator.validateWinningNumbers(parsedWinningNumbers)
                winningNumbers = parsedWinningNumbers
                break
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }

        // 보너스 번호 입력
        while (true) {
            try {
                outputView.printBonusNumberPrompt()
                val bonusNumberInput = inputView.inputBonusNumber()
                inputValidator.validateBonusNumber(bonusNumberInput, winningNumbers)
                bonusNumber = bonusNumberInput.toInt()
                break
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }

        // 당첨 통계 출력
        val lottoDrawingController = LottoDrawingController(lottoTicket, winningNumbers, bonusNumber, winningStatistics)
        lottoDrawingController.calculateMatchCount()
        val fifthCount = winningStatistics.matchCountStatistics[0]
        val fourthCount = winningStatistics.matchCountStatistics[1]
        val thirdCount = winningStatistics.matchCountStatistics[2]
        val secondCount = winningStatistics.matchCountStatistics[3]
        val firstCount = winningStatistics.matchCountStatistics[4]
        outputView.printWinningStatistics(fifthCount, fourthCount, thirdCount, secondCount, firstCount)

    }

}