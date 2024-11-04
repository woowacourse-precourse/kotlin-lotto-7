package lotto

import lotto.utils.InputManager
import lotto.utils.PrintManager

fun main() {

    val money = InputManager.getPurchaseMoney()
    val lottoMachine = LottoMachine(money)

    PrintManager.printCreatedLotto(lottoMachine.lottoSet)

    val winningNumbers = InputManager.getWinningNumbers()
    val bonusNumbers = InputManager.getBonusNumber(winningNumbers)
    lottoMachine.updateWinningNumber(winningNumbers, bonusNumbers)

    PrintManager.printWinningStatistics(
        winningRankSet = lottoMachine.winningRankSet,
        earningsRate = lottoMachine.getEarningsRate(),
    )
}

