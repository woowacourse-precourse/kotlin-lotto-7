package lotto.controller

import lotto.view.InputView
import lotto.Validator

class LottoController {
    private val inputView = InputView()
    private val validator = Validator()

    private fun getLottoPurchaseAmount(): Int {
        return try {
            val lottoPurchase = inputView.purchaseLottoMessage()
            validator.checkLottoPurchaseAmount(lottoPurchase)
            lottoPurchase.toInt()
        } catch (e: IllegalArgumentException) {
            getLottoPurchaseAmount()
        }
    }

}