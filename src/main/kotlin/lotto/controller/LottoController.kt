package lotto.controller

import lotto.model.InputValidator
import lotto.model.Lotto
import lotto.model.LottoTicket
import lotto.utils.Constants.LOTTO_PRICE
import lotto.view.InputView
import lotto.view.OutputView

/**
 * 컨트롤러는 모델과 뷰에 의존해도 된다.
 * 컨트롤러 내부에 모델과 뷰의 코드가 있을 수 있다.
 */

class LottoController {
    val inputView = InputView()
    val outputView = OutputView()

    //val winningNumbers by lazy { getVaildWinningNumbers() }

    fun start() {
        val purchaseAmount = getVaildPurchaseAmount()
        val purchaseCount = purchaseAmount / LOTTO_PRICE
        val purchaseLottoTickets = List(purchaseCount) { LottoTicket(Lotto.generate()) }

        outputView.showPurchasedLottoCount(purchaseCount, purchaseLottoTickets)

        val winningNumbers = getVaildWinningNumbers()
        val bonusNumber = getValidBonusNumber(winningNumbers)

        // 당첨 등급 출력
        //outputView.showWinningStatistics()

        // 수익률 출력
        //outputView.showTotalReturnRate()
    }

    private fun getVaildPurchaseAmount(): Int {
        while (true) {
            try {
                val purchaseAmount = inputView.getPurchaseAmount()
                InputValidator.validatePurchaseAmount(purchaseAmount)
                return purchaseAmount!!
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun getVaildWinningNumbers(): List<Int> {
        while (true) {
            try {
                val winningNumbers = inputView.getWinningNumbers()
                Lotto(winningNumbers)
                return winningNumbers
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun getValidBonusNumber(winningNumbers: List<Int>): Int {
        while (true) {
            try {
                val bonusNumber = inputView.getBonusNumber()
                InputValidator.validateBonusNumber(bonusNumber, winningNumbers)
                return bonusNumber!!
            } catch (e: Exception) {
                println(e.message)
            }
        }
    }
}