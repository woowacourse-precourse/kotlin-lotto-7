package lotto.controller

import lotto.utils.Validator
import lotto.viewm.InputView


object Controller {
    val validate = Validator()
    private var lottoBuyNumber = 0
    fun run() {
        while (true) {
            try {
                validate.validateInputAmount(InputView.inputPurchaseAmount())
                lottoBuyNumber = InputView.inputPurchaseAmount().toInt() / 1000
                break
            } catch (e: IllegalArgumentException) {
                println(e)
            }

        }

    }

}