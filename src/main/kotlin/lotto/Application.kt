package lotto

import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    OutputView().printPurchaseAmountPrompt()
    InputView().inputPurchaseAmount()
}
