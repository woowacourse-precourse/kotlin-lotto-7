package lotto

import lotto.utils.InputManager

fun main() {

    val money = InputManager.getMoney()
    val lottoMachine = LottoMachine(money)
    val winningNumbers = InputManager.getWinningNumbers()
    val bonusNumbers = InputManager.getBonusNumber()
    lottoMachine.updateWinningNumber(winningNumbers, bonusNumbers)
}
