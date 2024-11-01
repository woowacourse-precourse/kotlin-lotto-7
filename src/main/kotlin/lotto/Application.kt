package lotto

import lotto.domain.LottoMachine
import lotto.ui.InputView
import lotto.ui.OutputView

fun main() {
    LottoMachine(InputView, OutputView).start()
}
