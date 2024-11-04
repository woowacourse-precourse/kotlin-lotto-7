package lotto

import lotto.controller.LottoController
import lotto.domain.numberGenerator.RandomNumberGenerator

fun main() {
    val lottoGame = LottoController(RandomNumberGenerator())

    lottoGame.draw()
}