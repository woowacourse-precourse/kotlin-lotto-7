package lotto.domain

import lotto.data.Client
import lotto.data.Lotto
import lotto.data.Winning
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
        val winning = buildWinning()
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

    private fun buildWinning(): Winning {
        return try {
            outputView.printNewLine()
            Winning(inputView.readWinningNumbers())
        } catch (e: IllegalArgumentException) {
            printErrorCauseMessage(e.message)
            buildWinning()
        }
    }

    private fun printErrorCauseMessage(message: String?) {
        message?.let { outputView.printErrorCauseMessage(it) }
            ?: outputView.printOtherErrorMessage()
    }
}