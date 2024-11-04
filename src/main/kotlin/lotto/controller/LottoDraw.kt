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
        outputView.purchasedLotto(lottos)

        val ranking = LottoResultChecker.checkWinningStatus(lottos, myLotto, myBonus)
        val profitRatio = LottoResultChecker.calculateProfitRate(price, ranking)
        outputView.resultStatistics(ranking, profitRatio)
    }
}