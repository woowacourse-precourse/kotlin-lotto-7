package lotto.presenter

import lotto.model.Lotto
import lotto.model.LottoSeller
import lotto.view.OutputView

class LottoPresenter(
    private val inputPresenter: InputPresenter,
    private val outputView: OutputView
) {

    fun purchaseLotto(): List<Lotto> {
        val amount = inputPresenter.onPurchaseAmountInput()
        val lottoSeller = LottoSeller(amount)
        val lottoBundle = lottoSeller.sell()
        outputView.printPurchaseSummary(lottoBundle)
        return lottoBundle
    }
}