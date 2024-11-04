package lotto

import lotto.controller.LottoController
import lotto.domain.numbergenerator.RandomNumberGenerator

fun main() {
    val lottoGame = LottoController(RandomNumberGenerator())
    lottoGame.draw()
}
