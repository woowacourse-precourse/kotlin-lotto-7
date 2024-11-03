package lotto.controller

import lotto.model.Lotto
import lotto.model.Store
import lotto.view.InputView
import lotto.view.OutputView

class LottoDraw {
    fun run(inputView: InputView, outputView: OutputView) {
        val price = inputView.getPrice()

        val store = Store()
        val lottos = store.buyLotto(price)

        outputView.purchasedMessage(store.numberOfLottoPurchased)
        outputView.lottoList(lottos)

        val myLotto = Lotto(inputView.getLottoNumber())
        val myBonus = inputView.getBonusNumber()

        val (winningCounts, bonusWin) = LottoResultChecker.checkWinningStatus(lottos, myLotto, myBonus)
        val profitRatio = LottoResultChecker.calculateProfitRate(price, winningCounts, bonusWin)
        outputView.resultStatistics(winningCounts, bonusWin, profitRatio)
    }
}