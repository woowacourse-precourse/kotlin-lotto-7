package lotto.presenter

import lotto.view.InputView

class InputPresenter(private val inputView: InputView) {

    fun onPurchaseAmountInput(): Int {
        while (true) {
            try {
                val amount = inputView.readPurchaseAmount()
                // TODO 검증예외처리
                return amount.toInt()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}