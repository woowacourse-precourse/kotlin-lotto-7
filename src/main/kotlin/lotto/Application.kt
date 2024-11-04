package lotto

import lotto.manager.BonusNumberManager
import lotto.manager.LottoBuyManager
import lotto.manager.LottoResultManager
import lotto.manager.WinningNumberManager
import lotto.model.Lotto

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
