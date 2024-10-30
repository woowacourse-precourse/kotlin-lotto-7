package lotto.controller

import lotto.utils.Validator
import lotto.view.InputView


class LottoController{

    fun run() {
        val purchaseMoney = getPurchaseMoney()
    }

    private fun getPurchaseMoney() : Int  {
        val input = InputView.getPurchaseMoney()
        Validator.isValidPurchaseMoney(input)
        return input.toInt()
    }
}