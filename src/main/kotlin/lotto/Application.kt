package lotto

import template.controller.GameController

fun main() {
    val lottoGame = GameController.create()
    lottoGame.gameStart()
}
