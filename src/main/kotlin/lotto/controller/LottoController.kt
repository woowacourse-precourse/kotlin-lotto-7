package lotto.controller

import lotto.model.LottoHandler
import lotto.util.Constant
import lotto.view.InputView

class LottoController {
    fun run() {
        val inputView = InputView()
        val lottoHandler = LottoHandler()

        val lottoMoney = inputView.readLottoMoney()
        val lottoCount = lottoMoney / Constant.LOTTO_PRICE
        lottoHandler.generateLottos(lottoCount)
    }
}
