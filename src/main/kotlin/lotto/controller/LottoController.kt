package lotto.controller

import camp.nextstep.edu.missionutils.Console
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
        val winningResult = WinningResult(lottoAmount.lottos)

        totalResult(winningResult, inputNumbers, purchasePrice)
    }

    private fun getPrizeRankMsg(countByMatchCount: List<Int>): List<String> {
        return Ranking.entries.mapIndexed { index, ranking ->
            "${ranking.formattedMsg()}${countByMatchCount[index]}개"
        }
    }

    private fun totalResult(winningResult: WinningResult, inputNumbers: InputNumbers, purchasedPrice: String) {
        output.winningResultMsg(getPrizeRankMsg(winningResult.getMatchCount(inputNumbers)))
        output.profitRateMsg(winningResult.rate(purchasedPrice))
    }
}
