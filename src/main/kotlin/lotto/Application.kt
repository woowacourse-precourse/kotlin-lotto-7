package lotto

import lotto.controller.GameController

fun main() {
    val lottoGame = GameController.create()
    lottoGame.gameStart()
}
