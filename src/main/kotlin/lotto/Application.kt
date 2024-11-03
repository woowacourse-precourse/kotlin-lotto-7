package lotto

import lotto.controller.LottoGameController
import lotto.service.LottoGameService
import lotto.view.LottoGameView

fun main() {
    val lottoGameView = LottoGameView()
    val lottoGameService = LottoGameService()
    val lottoGameController = LottoGameController(lottoGameView, lottoGameService)
    lottoGameController.start()
}
