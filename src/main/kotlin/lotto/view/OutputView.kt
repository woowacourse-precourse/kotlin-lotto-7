package lotto.view

import lotto.Lotto
import lotto.util.InfoMessages
import lotto.util.InputMessages

class OutputView {

    fun printPurchaseAmountPrompt() {
        println(InputMessages.PURCHASE_AMOUNT_PROMPT)
    }

    fun printNumberOfPurchase(numberOfPurchase: Int) {
        println()
        println("${numberOfPurchase}${InfoMessages.PURCHASE_AMOUNT_INFO}")
    }

    fun printUserLottoNumbers(lottoTickets: List<Lotto>) {
        for (lotto in lottoTickets) {
            println(lotto.getNumbers())
        }
    }

}