package lotto

class LottoMachine {
    fun run() {
        val inputView = InputView()
        val outputView = OutputView()

        val purchaseAmount = inputView.getPurchaseAmount()
        val lottoCount = purchaseAmount / 1000

        val myLotto = Lotto.issueLotto(lottoCount)
        outputView.printLottoCount(lottoCount, myLotto)

        val winningNumbers = inputView.getLottoNumbers()
        val bonusNumber = inputView.getBonusNumber()

        val lotto = Lotto(winningNumbers)
        lotto.getLottoRank(myLotto, bonusNumber)
        outputView.printLottoRank(lotto)

        val profitRate = lotto.calculateProfitRate(purchaseAmount)
        outputView.printProfitRate(profitRate)
    }
}