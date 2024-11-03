package lotto.controller

import lotto.model.Lotto
import lotto.model.LottoGenerator
import lotto.model.PurchaseAmount
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val lottoGenerator = LottoGenerator()

    fun run() {
        val purchaseAmount = getPurchaseAmount()
        val purchaseQuantity = purchaseAmount.calculatePurchaseQuantity()
        val lottoTickets = getLottoTickets(purchaseQuantity)
        outputView.printPurchaseLotto(lottoTickets, purchaseQuantity)

    }

    private fun getPurchaseAmount(): PurchaseAmount {
        return try {
            outputView.printPurchaseAmountRequest()
            val userInput = inputView.readLine().toInt()
            PurchaseAmount(userInput)
        } catch(e:IllegalArgumentException) {
            println(e.message)
            getPurchaseAmount()
        }
    }

    private fun getLottoTickets(quantity: Int): List<Lotto> {
        val lottos = mutableListOf<Lotto>()
        repeat(quantity) {
            lottos.add(lottoGenerator.createLotto())
        }
        return lottos
    }
}