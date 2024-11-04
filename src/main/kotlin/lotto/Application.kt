package lotto

fun main() {
    val lottoBuyManager = LottoBuyManager()
    lottoBuyManager.requestMoney()
    lottoBuyManager.buyLottos()

    val winningNumberManager = WinningNumberManager()
    winningNumberManager.requestWinningNumbers()

    val winningLotto = Lotto(winningNumberManager.winningNumbers)
    val bonusNumberManager = BonusNumberManager(winningLotto)
    bonusNumberManager.requestBonusNumber()

    val lottoResultManager = LottoResultManager(
        lottoBuyManager.userLottos,
        winningLotto,
        bonusNumberManager.bonusNumber,
        lottoBuyManager.buyMoney
    )
    lottoResultManager.calculateRankResults()
    lottoResultManager.showResult()
}
