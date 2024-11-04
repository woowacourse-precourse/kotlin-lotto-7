package lotto.controller

import lotto.model.Lotto
import lotto.model.Store
import lotto.util.ErrorMessages
import lotto.view.InputView
import lotto.view.OutputView

class LottoDraw {
    fun run(inputView: InputView, outputView: OutputView) {
        val price = inputView.getPrice()

        val store = Store()
        val lottos = store.buyLotto(price)

        val myLotto = inputView.getMyLotto()
        val myBonus = inputView.getBonusNumber(myLotto)

        outputView.purchasedMessage(store.numberOfLottoPurchased)
        outputView.lottoList(lottos)

        val (winningCounts, bonusWin) = LottoResultChecker.checkWinningStatus(lottos, myLotto, myBonus)
        val profitRatio = LottoResultChecker.calculateProfitRate(price, winningCounts, bonusWin)
        outputView.resultStatistics(winningCounts, bonusWin, profitRatio)
    }
}