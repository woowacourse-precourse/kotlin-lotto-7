package lotto.controller

import lotto.model.*
import lotto.util.RepeatFunction
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    fun run() {
        val purchaseAmount = getPurchaseAmount()
        val lottos = getLottos(purchaseAmount)
        val winningNumbers = getWinningNumbers()
        val lottoResults = winningNumbers.matchLotto(lottos)
        OutputView.printLottoResult(lottoResults)
        OutputView.printProfit(lottoResults.calculateProfit(purchaseAmount))
    }

    private fun getPurchaseAmount(): PurchaseAmount {
        return RepeatFunction.executeWithRetry {
            val purchaseAmount = InputView.inputPurchaseAmount()
            PurchaseAmount(purchaseAmount)
        }
    }

    private fun getLottos(purchaseAmount: PurchaseAmount): List<Lotto> {
        val lottos = LottoMachine.issueLotto(purchaseAmount)
        OutputView.printPurchaseLotto(lottos)
        return lottos
    }

    private fun getWinningNumbers(): WinningNumbers {
        return RepeatFunction.executeWithRetry {
            val numbers = InputView.inputMainNumbers()
            val mainNumbers = Lotto(numbers)
            val number = InputView.inputBonusNumber()
            val bonusNumber = LottoNumber(number)
            WinningNumbers(mainNumbers, bonusNumber)
        }
    }
}
