package lotto.controller

import lotto.view.InputView

class LottoController {
    fun draw() {
        val money = InputView.getMoney()
        val winningNum = InputView.getWinningNumber()
    }
}