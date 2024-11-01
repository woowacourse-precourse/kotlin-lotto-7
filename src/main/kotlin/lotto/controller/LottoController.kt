package lotto.controller

import lotto.model.Lotto
import lotto.model.LottoMachine
import lotto.model.PurchaseAmount
import lotto.util.InputValidator.validateInputIsNotEmpty
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView(),
) {

    fun run() {
        val purchaseAmount = receivePurchaseAmount()
        val lottos = purchaseLotto(purchaseAmount)
        outputView.printPurchasedLottoCount(lottos.size)
        outputView.printPurchasedLottoNumbers(lottos.map { it.getLottoNumbers() })
    }

    private fun receivePurchaseAmount(): PurchaseAmount {
        while (true) {
            try {
                val rawPurchaseAmount = inputView.receivePurchaseAmount()
                validateInputIsNotEmpty(rawPurchaseAmount)

                val purchaseAmount = PurchaseAmount()
                purchaseAmount.setPurchaseAmount(rawPurchaseAmount)

                return purchaseAmount
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun purchaseLotto(purchaseAmount: PurchaseAmount): List<Lotto> {
        val lottoMachine = LottoMachine()
        val lottos = lottoMachine.purchaseLottos(purchaseAmount.getPurchaseAmount())

        return lottos
    }
}