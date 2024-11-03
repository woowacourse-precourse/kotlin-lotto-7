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
        processPurchaseAmount()
        purchaseLottoTickets()
        processWinningNumbers()
        processBonusNumber()
        calculateStatistics()
    }

    // 구입 금액 입력 처리
    private fun processPurchaseAmount() {
        var isValid = false
        while (!isValid) {
            try {
                outputView.printPurchaseAmountPrompt()
                val purchaseAmountInput = inputView.inputPurchaseAmount().trim()
                inputValidator.validatePurchaseAmount(purchaseAmountInput)
                purchaseAmount = purchaseAmountInput.toInt()
                isValid = true
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    // 구매한 로또 개수 계산 및 로또 저장
    private fun purchaseLottoTickets() {
        lottoPurchaseController.calculateNumberOfPurchase(purchaseAmount)
        outputView.printNumberOfPurchase(lottoTicket.numberOfPurchase)

        lottoPurchaseController.saveUserLottoNumbers()
        outputView.printUserLottoNumbers(lottoTicket.userLottoNumbers)
    }

    // 당첨 번호 입력 처리
    private fun processWinningNumbers() {
        var isValid = false
        while (!isValid) {
            try {
                outputView.printWinningNumbersPrompt()
                val winningNumbersInput = inputView.inputWinningNumbers()
                val parsedWinningNumbers = winningNumbersInput.split(",").map { it.trim().toIntOrNull() }
                inputValidator.validateWinningNumbers(parsedWinningNumbers)
                winningNumbers = parsedWinningNumbers
                isValid = true
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    // 보너스 번호 입력 처리
    private fun processBonusNumber() {
        var isValid = false
        while (!isValid) {
            try {
                outputView.printBonusNumberPrompt()
                val bonusNumberInput = inputView.inputBonusNumber().trim()
                inputValidator.validateBonusNumber(bonusNumberInput, winningNumbers)
                bonusNumber = bonusNumberInput.toInt()
                isValid = true
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    // 당첨 통계 및 수익률 계산
    private fun calculateStatistics() {
        val lottoDrawingController = LottoDrawingController(lottoTicket, winningNumbers, bonusNumber, winningStatistics)
        lottoDrawingController.calculateMatchCount()

        val (fifthCount, fourthCount, thirdCount, secondCount, firstCount) = winningStatistics.matchCountStatistics
        outputView.printWinningStatistics(fifthCount, fourthCount, thirdCount, secondCount, firstCount)

        lottoDrawingController.calculateTotalPrize()
        val returnRate = lottoDrawingController.calculateReturnRate(purchaseAmount)
        outputView.printReturnRate(returnRate)
    }

}