package lotto.controller

import camp.nextstep.edu.missionutils.Randoms
import lotto.constant.LOTTO_SIZE
import lotto.constant.MAX_LOTTO_NUMBER
import lotto.constant.MIN_LOTTO_NUMBER
import lotto.model.Lotto
import lotto.model.PurchaseMoney
import lotto.model.WinningLotto
import lotto.model.WinningResult
import lotto.view.InputView.getPurchaseMoneyInput
import lotto.view.InputView.getWinningLottoInput
import lotto.view.InputView.getBonusNumberInput
import lotto.view.OutputView.printLottoCount
import lotto.view.OutputView.printLottoNumber
import lotto.view.OutputView.printWinningResult
import lotto.view.OutputView.printYieldRate


class LottoController {

    fun run() {
        val purchaseMoney = getPurchaseMoney()
        val lottoCount = getLottoCount(purchaseMoney.money, purchaseMoney.getUnitPrice())
        printLottoCount(lottoCount)

        val lottos = getLottos(lottoCount)
        printLottoNubmers(lottos)

        val winningLotto = getWinningLotto()
        getBonusNumber(winningLotto)

        val winningResult = getWinningResult(lottos, winningLotto)
        printWinningResult(winningResult)
        printYieldRate(purchaseMoney, winningResult)
    }

    private fun getPurchaseMoney(): PurchaseMoney {
        while(true) {
            try {
                val moneyinput = getPurchaseMoneyInput()
                return PurchaseMoney(moneyinput)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }

    }

    private fun getLottoCount(purchaseMoney: Int, unitPrice: Int): Int {
        return purchaseMoney / unitPrice
    }

    private fun makeLottoNumbers(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_SIZE).sorted()
    }

    private fun getLottos(lottoCount: Int): MutableList<Lotto> {
        return MutableList(lottoCount) { Lotto(makeLottoNumbers()) }
    }

    private fun printLottoNubmers(lottos: MutableList<Lotto>) {
        lottos.forEach { lotto ->
            printLottoNumber(lotto.numbers)
        }
    }

    private fun getWinningLotto(): WinningLotto {
        while(true) {
            try {
                val winningLottoInput = getWinningLottoInput()
                return WinningLotto(winningLottoInput)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }

    }

    private fun getBonusNumber(winningLotto: WinningLotto) {
        while(true) {
            try {
                val bonusNumberInput = getBonusNumberInput()
                winningLotto.setBonusNumber(bonusNumberInput)
                return
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun getWinningResult(lottos: List<Lotto>, winningLotto: WinningLotto): WinningResult {
        val lottoRanks = lottos.map { winningLotto.getRank(it) }
        return WinningResult.convertToResult(lottoRanks)
    }

}
