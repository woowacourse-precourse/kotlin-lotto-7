package lotto.domain

import lotto.data.Client
import lotto.data.Lotto
import lotto.ui.InputView
import lotto.ui.OutputView

class LottoMachine(
    private val inputView: InputView,
    private val outputView: OutputView
) {
    fun start() {
        val client = buildClient()
        printLottoQuantity(client.lotto)
        printLottoNumbers(client.lottoNumbers)
    }

    private fun buildClient(): Client {
        return try {
            Client(inputView.readLottoAmount())
        } catch (e: IllegalArgumentException) {
            printErrorCauseMessage(e.message)
            buildClient()
        }
    }

    private fun printLottoQuantity(lotto: List<Lotto>) {
        outputView.printNewLine()
        outputView.printLottoQuantity(lotto.size)
    }

    private fun printLottoNumbers(lottoNumbers: List<List<Int>>) {
        for (lottoNumber in lottoNumbers) {
            outputView.printLottoNumber(lottoNumber)
        }
    }

    private fun printErrorCauseMessage(message: String?) {
        message?.let { outputView.printErrorCauseMessage(it) }
            ?: outputView.printOtherErrorMessage()
    }
}