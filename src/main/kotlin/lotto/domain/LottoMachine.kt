package lotto.domain

import lotto.data.LottoAmount
import lotto.data.LottoAmount.Companion.convertAmountToQuantity
import lotto.ui.InputView
import lotto.ui.OutputView
import lotto.utils.Random

class LottoMachine(
    private val inputView: InputView,
    private val outputView: OutputView
) {
    fun start() {
        val lottoAmount = buildLottoAmount()
        val lottoQuality = lottoAmount.convertAmountToQuantity()
        printLottoQuantity(lottoQuality)
        val lottoNumbers = createLottoNumbers(lottoQuality)
        printLottoNumbers(lottoNumbers)
    }

    private fun buildLottoAmount(): LottoAmount {
        return try {
            LottoAmount(inputView.readLottoAmount())
        } catch (e: IllegalArgumentException) {
            printErrorCauseMessage(e.message)
            buildLottoAmount()
        }
    }

    private fun printLottoQuantity(quantity: Int) {
        outputView.printNewLine()
        outputView.printLottoQuantity(quantity)
    }

    private fun createLottoNumbers(quantity: Int) = List(quantity) { Random.crateLottoNumbers() }

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