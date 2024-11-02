package lotto.controller

import lotto.model.*
import lotto.view.LottoView

class LottoController {
    private val lottoPurchase = LottoPurchase()
    private val lottoIssue = LottoIssue()
    private val lottoView = LottoView()
    private val lottoStatistics = LottoStatistics()

    fun run() {
        val purchaseAmount = lottoPurchase.getPurchaseAmount()
        val lottoCount = lottoPurchase.calculateLottoCount(purchaseAmount)
        val issuedLottos = lottoIssue.issueLottos(lottoCount)

        lottoView.displayPurchaseCount(issuedLottos.size)
        issuedLottos.forEach { println(it.getNumbers()) }

        val winningNumber = WinningNumber()
        val winningNumbers = winningNumber.getWinningNumber(lottoView)

        var bonusNumber: Int
        do {
            bonusNumber = lottoView.readBonusNumber()
        } while (bonusNumber == -1 || !BonusNumber().getBonusNumber(bonusNumber, winningNumbers)) // 유효한 번호가 입력될 때까지 반복

        lottoView.displayWinningStatistics() // 당첨 통계 출력
        val statistics = lottoStatistics.calculateStatistics(issuedLottos, winningNumbers, bonusNumber)
        lottoView.displayStatistics(statistics)

        // 수익률 계산 및 출력
        val yield = lottoStatistics.calculateYield(statistics, purchaseAmount)
        lottoView.displayYield(yield) // 수익률 출력
    }
}
