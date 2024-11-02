package lotto.controller

import lotto.model.*
import lotto.view.LottoView

class LottoController {
    private val lottoPurchase = LottoPurchase()
    private val lottoIssue = LottoIssue()
    private val lottoView = LottoView()
    private val lottoStatistics = LottoStatistics()

    fun run() {
        val purchaseAmountStr = lottoPurchase.getPurchaseAmount()
        val lottoCount = lottoPurchase.calculateLottoCount(purchaseAmountStr)
        val issuedLottos = lottoIssue.issueLottos(lottoCount)

        lottoView.displayPurchaseCount(issuedLottos.size)
        issuedLottos.forEach { println(it.getNumbers()) }

        val winningNumber = WinningNumber()
        val winningNumbers = winningNumber.getWinningNumber(lottoView)

        val bonusNumber = BonusNumber(lottoView) // LottoView를 사용하여 BonusNumber 객체 생성
        val actualBonusNumber = bonusNumber.getBonusNumber(winningNumbers) // winningNumbers를 전달

        lottoView.displayWinningStatistics() // 당첨 통계 출력
        val statistics = lottoStatistics.calculateStatistics(issuedLottos, winningNumbers, actualBonusNumber)
        lottoView.displayStatistics(statistics)

        // 수익률 계산 및 출력
        val yield = lottoStatistics.calculateYield(statistics, purchaseAmountStr)
        lottoView.displayYield(yield) // 수익률 출력
    }


}
