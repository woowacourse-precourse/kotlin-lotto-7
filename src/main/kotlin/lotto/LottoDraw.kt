package lotto

class LottoDraw {
    fun run(inputView: InputView) {
        val price = inputView.getPrice()
        val myLotto = Lotto(inputView.getLottoNumber())
        val myBonus = inputView.getBonusNumber()

        val lottos = Store.buyLotto(price)
        val(winningCounts, bonusWin) = LottoResultChecker.checkWinningStatus(lottos, myLotto, myBonus)
        val profitRatio = LottoResultChecker.calculateProfitRate(price, winningCounts, bonusWin)
    }
}