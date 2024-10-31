package lotto

import lotto.controller.LottoController
import lotto.view.InputView

fun main() {
    // TODO: 프로그램 구현
    val lottoController = LottoController()

    lottoController.purchaseLotto()
    lottoController.setLotteryNumber()
}
