package lotto.controller

import lotto.model.PurchaseMoney
import lotto.view.InputView


class LottoController{

    fun run() {
        val purchaseMoney = getPurchaseMoney()
    }

    private fun getPurchaseMoney() : PurchaseMoney  {
        val moneyinput = InputView.getPurchaseMoney()
        return PurchaseMoney(moneyinput)
    }
}