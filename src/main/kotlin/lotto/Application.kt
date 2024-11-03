package lotto

import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    LottoMachine(InputView(), OutputView(), LottoService()).start()
}
