package lotto

import lotto.model.LottoSeller
import lotto.presenter.InputPresenter
import lotto.view.InputViewImpl
import lotto.view.OutputViewImpl

class LottoApplication {

    fun run() {
        val inputView = InputViewImpl()
        val outputView = OutputViewImpl()
        val inputPresenter = InputPresenter(inputView, outputView)
        val amount = inputPresenter.onPurchaseAmountInput()
        val lottoSeller = LottoSeller(amount)
        val lottoBundle = lottoSeller.sell()
        outputView.printPurchaseSummary(lottoBundle)
    }
}