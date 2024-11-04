package lotto

import lotto.controller.LottoController
import lotto.view.LottoView

fun main() {
    // TODO: 프로그램 구현
    val lottoView = LottoView()
    val lottoController = LottoController(lottoView)

    lottoController.run()
}
