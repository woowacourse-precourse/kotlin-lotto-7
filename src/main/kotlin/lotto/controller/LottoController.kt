package lotto.controller

import lotto.domain.entity.Lotto
import lotto.service.LottoService
import lotto.view.InputView
import lotto.view.OutputView
import lotto.validator.LottoValidator

class LottoController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val service: LottoService,
    private val validator: LottoValidator,
) {
    private var purchasePrice: Int = 0
    private lateinit var winLotto: Lotto
    private var bonusNumber: Int = 0

    fun run() {
        purchasePrice = loopUntilValid { validator.validatePurchasePrice(inputView.getPurchasePrice()) }
        val lottos = service.purchaseLottos(purchasePrice)
        outputView.showRandomLottos(lottos)

        winLotto = loopUntilValid { validator.validateWinningLotto(inputView.getWinningNumbers()) }
        bonusNumber = loopUntilValid { validator.validateBonusNumber(inputView.getBonusNumber(), winLotto) }

        service.matchAllLotto(winLotto, lottos, bonusNumber)
        outputView.showStatus()

        val resultMoney = service.getResultMoney()
        val profitRate = service.getProfitRate(purchasePrice, resultMoney)
        outputView.showProfitRate(profitRate)
    }

    private fun <T> loopUntilValid(action: () -> T): T {
        while (true) {
            try {
                return action()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}