package lotto.controller

import lotto.model.*
import lotto.view.LottoView

class LottoController {
    private val lottoPurchase = LottoPurchase()
    private val lottoIssue = LottoIssue()
    private val lottoView = LottoView()

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

        lottoView.displayWinningNumbers(winningNumbers)
        lottoView.displayBonusNumber(bonusNumber)
    }
}
