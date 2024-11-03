package lotto.Controller

import lotto.Lotto
import lotto.Model.InputValidater
import lotto.Model.RandomLottoMaker
import lotto.Model.WinningLottoResult
import lotto.View.InputView
import lotto.View.OutputView

class LottoController {
    private val inputView = InputView()
    private val outputView = OutputView()
    private var releasedLottos = listOf<Lotto>()
    private lateinit var winningLottoResult: WinningLottoResult

    fun execute() {
        getInputsAndReleaseLottos()
        outputView.printLottoResult(releasedLottos, winningLottoResult)
    }

    private fun getInputsAndReleaseLottos() {
        val purchaseAmount = getPurchaseInput()
        val lottoAmount = purchaseAmount / Lotto.COST
        releaseLottos(lottoAmount)
        val winningLotto = getWinningLotto()
        val bonusNumber = getBonusNumber(winningLotto)
        winningLottoResult = WinningLottoResult(winningLotto, bonusNumber)
    }

    private fun getPurchaseInput(): Int {
        while (true) {
            try {
                val purchaseAmount = inputView.getPurchaseAmount()
                InputValidater.validatePurchaseAmount(purchaseAmount)
                return purchaseAmount.toInt()
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

    private fun getBonusNumber(winningLotto: Lotto): Int {
        while (true) {
            try {
                val inputBonusNumber = inputView.getBonusNumber()
                InputValidater.validateBonusNumber(winningLotto, inputBonusNumber)
                return inputBonusNumber.toInt()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun releaseLottos(lottoAmount: Int) {
        releasedLottos = RandomLottoMaker.makeLottos(lottoAmount)
        outputView.printLottos(releasedLottos)
    }

    companion object {
        private const val LOTTO_SPLIT_DELIMITER = ","
    }
}