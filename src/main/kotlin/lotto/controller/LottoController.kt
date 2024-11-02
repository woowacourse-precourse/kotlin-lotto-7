package lotto.controller

import lotto.model.Processor
import lotto.view.InputView

class LottoController {
    fun draw() {
        val money = InputView.getMoney()
        val winningNum = Processor.winningNumSplit(InputView.getWinningNumber())
    }
}