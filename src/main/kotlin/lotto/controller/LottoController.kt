package lotto.controller

import camp.nextstep.edu.missionutils.Console
import lotto.domain.InputNumbers
import lotto.domain.LottoAmount
import lotto.domain.WinningResult
import lotto.utils.Error
import lotto.view.Input
import lotto.view.Output

class LottoController {
    private val input = Input()
    private val output = Output()

    fun run() {
        val lottoAmount = getValidPurchasePrice()

        input.purchasedQuantityMsg(lottoAmount.purchaseCount, lottoAmount.lottos)

        val winningNumbers = getValidWinningNumbers()

        val bonusNumber = getValidBonusNumber()
        val inputNumbers = InputNumbers(winningNumbers, bonusNumber)

        totalResult(lottoAmount.purchasePrice, lottoAmount, inputNumbers)
    }

    private fun getValidPurchasePrice(): LottoAmount {
        while (true) {
            try {
                input.purchasePriceMsg()
                val purchasePrice = Console.readLine()
                Error.priceError(purchasePrice)
                return LottoAmount(purchasePrice)
            } catch (e: IllegalArgumentException) {
                println(e)
            }
        }
    }

    private fun getValidWinningNumbers(): String {
        while (true) {
            try {
                input.winningNumbersMsg()
                val winningNumbers = Console.readLine()
                Error.winningNumberError(winningNumbers)
                return winningNumbers
            } catch (e: IllegalArgumentException) {
                println(e)
            }
        }
    }

    private fun getValidBonusNumber(): String {
        while (true) {
            try {
                input.bonusNumberMsg()
                val bonusNumber = Console.readLine()
                Error.bonusNumberError(bonusNumber)
                return bonusNumber
            } catch (e: IllegalArgumentException) {
                println(e)
            }
        }
    }

    private fun totalResult(
        purchasedPrice: String,
        lottoAmount: LottoAmount,
        inputNumbers: InputNumbers
    ) {
        val winningResult = WinningResult(lottoAmount.lottos, inputNumbers)

        output.winningResultMsg(winningResult.getPrizeRankMsg())
        output.rateOfReturnMsg(winningResult.getRateOfReturn(purchasedPrice))
    }
}
