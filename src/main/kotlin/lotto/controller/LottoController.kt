package lotto.controller

import lotto.model.Lotto
import lotto.model.PurchaseMoney
import lotto.model.WinningLotto
import lotto.view.InputView.getPurchaseMoneyInput
import lotto.view.InputView.getWinningLottoInput
import lotto.view.InputView.getBonusNumberInput
import lotto.view.OutputView.printLottoCount
import lotto.view.OutputView.printLottoNumber
import lotto.view.OutputView.printWinningResult


class LottoController {

    fun run() {
        val purchaseMoney = getPurchaseMoney()
        val lottoCount = getLottoCount(purchaseMoney.money, purchaseMoney.getUnitPrice())
        printLottoCount(lottoCount)

        val lottos = getLottos(lottoCount)
        printLottoNubmers(lottos)

        val winningLotto = getWinningLotto()
        getBonusNumber(winningLotto)

        printWinningResult()

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

    private fun printLottoNubmers(lottos: MutableList<Lotto>) {
        lottos.forEach { lotto ->
            printLottoNumber(lotto.numbers)
        }
    }

    private fun getWinningLotto(): WinningLotto {
        val winningLottoInput = getWinningLottoInput()
        return WinningLotto(winningLottoInput)
    }

    private fun getBonusNumber(winningLotto: WinningLotto) {
        val bonusNumberInput = getBonusNumberInput()
        winningLotto.setBonusNumber(bonusNumberInput)
    }

}