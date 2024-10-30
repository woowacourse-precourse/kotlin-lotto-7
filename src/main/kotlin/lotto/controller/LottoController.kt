package lotto.controller

import camp.nextstep.edu.missionutils.Console
import lotto.constants.OutputConstants.COUNT
import lotto.domain.InputNumbers
import lotto.domain.LottoAmount
import lotto.domain.Ranking
import lotto.domain.WinningResult
import lotto.view.Input
import lotto.view.Output

class LottoController {
    private val input = Input()
    private val output = Output()

    fun run() {
        input.purchasePriceMsg()
        val purchasePrice = Console.readLine()

        val lottoAmount = LottoAmount(purchasePrice)
        input.purchasedQuantityMsg(lottoAmount.purchaseCount, lottoAmount.lottos)

        input.winningNumbersMsg()
        val winningNumbers = Console.readLine()

        input.bonusNumberMsg()
        val bonusNumber = Console.readLine()
        val inputNumbers = InputNumbers(winningNumbers, bonusNumber)

        totalResult(purchasePrice, lottoAmount, inputNumbers)
    }

    private fun totalResult(
        purchasedPrice: String,
        lottoAmount: LottoAmount,
        inputNumbers: InputNumbers
    ) {
        val winningResult = WinningResult(lottoAmount.lottos, inputNumbers)

        output.winningResultMsg(winningResult.getPrizeRankMsg())
        output.profitRateMsg(winningResult.rate(purchasedPrice))
    }
}
