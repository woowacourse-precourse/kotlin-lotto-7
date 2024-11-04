package lotto

import lotto.utils.InputManager

fun main() {
    val money = InputManager.getMoney()
    val lottoMachine = LottoMachine(money)
}
