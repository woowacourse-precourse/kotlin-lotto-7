package lotto.controller

import lotto.view.InputView
import lotto.view.OutputView
import lotto.Validator
import lotto.model.Lotto

class LottoController {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val validator = Validator()

    fun lottoGame() {
        val purchaseAmount = getLottoPurchaseAmount()
        val ticket = countLottoTicket(purchaseAmount)
        outputView.countTicketsMessage(ticket)
        outputView.generateTicketsMessage(ticket)
        val winLottoNumbers = Lotto(inputView.getWinLottoNumbers())
    }

    private fun getLottoPurchaseAmount(): Int {
        return try {
            val lottoPurchase = inputView.purchaseLottoMessage()
            validator.checkLottoPurchaseAmount(lottoPurchase)
            lottoPurchase.toInt()
        } catch (e: IllegalArgumentException) {
            getLottoPurchaseAmount()
        }
    }

    private fun countLottoTicket(purchaseAmount: Int): Int {
        return purchaseAmount / 1000
    }
}