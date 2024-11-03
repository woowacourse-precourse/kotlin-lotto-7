package lotto.controller

import lotto.utils.Validator
import lotto.viewm.InputView


object Controller {
    val validate = Validator()
    fun run() {
        while (true) {
            try {
                validate.validateInputAmount(InputView.inputPurchaseAmount())
                break
            } catch (e: IllegalArgumentException) {
                println(e)
            }

        }

    }

}