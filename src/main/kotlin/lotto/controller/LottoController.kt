package lotto.controller

import lotto.model.Lotto
import lotto.model.PurchaseMoney
import lotto.view.InputView.getPurchaseMoneyInput
import lotto.view.OutputView.printLottoCount
import lotto.view.OutputView.printLottoNumber


class LottoController {

    fun run() {
        val purchaseMoney = getPurchaseMoney()
        val lottoCount = getLottoCount(purchaseMoney.money, purchaseMoney.getUnitPrice())
        printLottoCount(lottoCount)

        val lottos = getLottos(lottoCount)
        printLottoNubmers(lottos)
    }

    private fun getPurchaseMoney(): PurchaseMoney {
        val moneyinput = getPurchaseMoneyInput()
        return PurchaseMoney(moneyinput)
    }

    private fun getLottoCount(purchaseMoney: Int, unitPrice: Int): Int {
        return purchaseMoney / unitPrice
    }

    private fun getLottos(lottoCount: Int): MutableList<Lotto> {
        return MutableList(lottoCount) { Lotto() }
    }

    private fun printLottoNubmers(lottos : MutableList<Lotto>) {
        lottos.forEach { lotto ->
            printLottoNumber(lotto.numbers)
        }
    }


}