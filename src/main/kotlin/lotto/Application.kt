package lotto

import lotto.controller.LottoController
import lotto.model.LottoService

fun main() {
    val controller = LottoController(LottoService())
    controller.start()
}
