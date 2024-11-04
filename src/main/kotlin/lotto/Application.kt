package lotto

import lotto.controller.LottoController
import lotto.view.Input
import lotto.view.Output

fun main() {
    val input: Input = Input()
    val output: Output = Output()
    val lottoController: LottoController = LottoController(input, output)

    lottoController.runMachine()
}
