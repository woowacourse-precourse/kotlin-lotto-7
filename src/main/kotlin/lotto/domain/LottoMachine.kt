package lotto.domain

import lotto.data.LottoAmount
import lotto.ui.InputView
import lotto.ui.OutputView

class LottoMachine(
    private val inputView: InputView,
    private val outputView: OutputView
) {
    fun start() {
        val lottoAmount = buildLottoAmount()
    }

    private fun buildLottoAmount(): LottoAmount {
        return try {
            LottoAmount(inputView.readLottoAmount())
        } catch (e: IllegalArgumentException) {
            printErrorCauseMessage(e.message)
            buildLottoAmount()
        }
    }

    private fun printErrorCauseMessage(message: String?) {
        message?.let { outputView.printErrorCauseMessage(it) }
            ?: outputView.printOtherErrorMessage()
    }
}