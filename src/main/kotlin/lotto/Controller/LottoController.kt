package lotto.Controller

import lotto.Lotto
import lotto.Model.InputValidater
import lotto.View.InputView

class LottoController {
    private val inputView = InputView()

    companion object {
        private const val LOTTO_SPLIT_DELIMITER = ","
    }

    fun getInputs() {
        val lottoAmount = getPurchaseInput()
        val winningLotto = getWinningLotto()
        val bonusNumber = inputView.getBonusNumber()
    }

    private fun getPurchaseInput(): Int {
        while (true) {
            try {
                val purchaseAmount = inputView.getPurchaseAmount()
                InputValidater.validatePurchaseAmount(purchaseAmount)
                return purchaseAmount.toInt() / 1000
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun getWinningLotto(): Lotto {
        while (true) {
            try {
                val inputWinningLotto = inputView.getWinningNumbers()
                val rawLottoNumbers = inputWinningLotto.split(LOTTO_SPLIT_DELIMITER)
                InputValidater.validateLottoNumbers(rawLottoNumbers)
                val lottoNumbers = rawLottoNumbers.map { it.toInt() }
                return Lotto(lottoNumbers)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}