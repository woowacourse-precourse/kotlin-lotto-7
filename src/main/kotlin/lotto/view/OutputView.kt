package lotto.view

import lotto.Lotto

object OutputView {
    fun OutputBuyLottoNumber(buyLotto: List<Lotto>) {
        for (lotto in buyLotto) {
            println(lotto)
        }
    }
}