package lotto

import lotto.model.LottoSeller
import lotto.presenter.InputPresenter
import lotto.view.InputViewImpl
import lotto.view.OutputViewImpl

class LottoApplication {

    fun run() {
        val input = InputViewImpl()
        val outputView = OutputViewImpl()
        val inputPresenter = InputPresenter(input)
        val amount = inputPresenter.onPurchaseAmountInput()
        val lottoSeller = LottoSeller(amount)
        val lottoBundle = lottoSeller.sell()
    }
}