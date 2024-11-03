package lotto.controller

import lotto.model.LottoHandler
import lotto.util.Constant
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    fun run() {
        val inputView = InputView()
        val outputView = OutputView()
        val lottoHandler = LottoHandler()

        val lottoMoney = inputView.readLottoMoney()
        val lottoCount = lottoMoney / Constant.LOTTO_PRICE
        outputView.printLottoCount(lottoCount)

        val lottos = lottoHandler.generateLottos(lottoCount)
        outputView.printLottos(lottos)

        val winningNumbers = inputView.readWinningNumbers()
        val bonusNumber = inputView.readBonusNumber()

        lottos.forEach { it.countMatches(winningNumbers) }
        lottos.forEach { it.hasBonus(bonusNumber) }
    }
}
