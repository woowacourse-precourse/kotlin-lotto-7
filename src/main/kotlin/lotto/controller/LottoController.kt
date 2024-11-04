package lotto.controller

import lotto.model.LottoFactory
import lotto.model.LottoResultCalculator
import lotto.util.validator.BonusNumberValidator
import lotto.util.validator.LottoNumberValidator
import lotto.util.validator.PurchaseAmountValidator
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView(),
) {
    private lateinit var lottoFactory: LottoFactory
    private lateinit var lottoResultCalculator: LottoResultCalculator
    private lateinit var winningNumbers: List<Int>
    private var bonusNumber: Int? = null

    fun run() {
        payment()
        giveLotteries()
        inputWinningNumber()
        showResult()
    }

    private fun payment() {
        val purchaseAmount = getValidatedInput(
            inputFunction = { inputView.getPurchaseAmount() },
            validationFunction = { PurchaseAmountValidator.getValidatePurchaseAmount(it) }
        )
        lottoFactory = LottoFactory(purchaseAmount)
    }

    private fun giveLotteries() {
        val lottoQuantity = lottoFactory.lottoQuantity
        val purchasedLotteries = lottoFactory.createLotto()
        lottoResultCalculator = LottoResultCalculator(purchasedLotteries)

        outputView.showLottoQuantity(lottoQuantity)
        outputView.showLottoNumbers(purchasedLotteries)
    }

    private fun inputWinningNumber() {
        winningNumbers = getValidatedInput(
            inputFunction = { inputView.getWinningNumber() },
            validationFunction = { LottoNumberValidator.getValidatedWinningNumbers(it) }
        )
        bonusNumber = getValidatedInput(
            inputFunction = { inputView.getBonusNumber() },
            validationFunction = { BonusNumberValidator.getValidatedBonusNumber(it, winningNumbers) }
        )
        inputView.close()
    }

    private fun showResult() {
        val lottoResults = lottoResultCalculator.getLottoResults(winningNumbers, bonusNumber!!)
        val purchaseAmount = lottoFactory.getPurchaseAmount()
        val yield = lottoResultCalculator.getLottoYield(lottoResults, purchaseAmount)

        outputView.showMatchingLottoAmount(lottoResults)
        outputView.showYield(yield)
    }

    private fun <T> getValidatedInput(
        inputFunction: () -> String,
        validationFunction: (String) -> T
    ): T {
        while (true) {
            try {
                val input = inputFunction()
                val validatedInput = validationFunction(input)
                return validatedInput
            } catch (e: IllegalArgumentException) {
                showErrorMessage(e)
            }
        }
    }

    private fun showErrorMessage(e: IllegalArgumentException) {
        val errorMessage = e.message
        if (errorMessage != null) {
            outputView.showErrorMessage(errorMessage)
        }
    }
}