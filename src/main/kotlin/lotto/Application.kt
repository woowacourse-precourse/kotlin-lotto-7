package lotto

fun main() {
    val lottoBuyManager = LottoBuyManager()
    lottoBuyManager.requestMoney()
    lottoBuyManager.buyLottos()

    val winningNumberManager = WinningNumberManager()
    winningNumberManager.requestWinningNumbers()

    val bonusNumberManager = BonusNumberManager(winningNumberManager.winningNumbers)
    bonusNumberManager.requestBonusNumber()
}
