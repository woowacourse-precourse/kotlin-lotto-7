package lotto

import lotto.utils.InputManager
import lotto.utils.PrintManager

fun main() {

    val money = InputManager.getMoney()
    val lottoMachine = LottoMachine(money)
    PrintManager.printCreatedLotto(lottoMachine.lottoSet)

    val winningNumbers = InputManager.getWinningNumbers()
    val bonusNumbers = InputManager.getBonusNumber()
    lottoMachine.updateWinningNumber(winningNumbers, bonusNumbers)
    PrintManager.printWinningStatistics(
        winningRankSet = lottoMachine.winningRankSet,
        earningsRate = lottoMachine.getEarningsRate(),
    )
}
