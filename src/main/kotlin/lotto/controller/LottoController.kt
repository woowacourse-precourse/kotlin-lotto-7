package lotto.controller

import lotto.model.PurchaseMoney
import lotto.view.InputView.getPurchaseMoneyInput
import lotto.view.OutputView.printLottoCount


class LottoController{

    fun run() {
        val purchaseMoney = getPurchaseMoney()
        val lottoCount = getLottoCount(purchaseMoney.money, purchaseMoney.getUnitPrice())
        printLottoCount(lottoCount)
    }

    private fun getPurchaseMoney() : PurchaseMoney  {
        val moneyinput = getPurchaseMoneyInput()
        return PurchaseMoney(moneyinput)
    }

    private fun getLottoCount(purchaseMoney: Int, unitPrice : Int) : Int {
        return purchaseMoney / unitPrice
    }

}