package lotto

import camp.nextstep.edu.missionutils.Console.readLine

fun main() {
    val lottoSalesMachine = LottoSalesMachine()
    println(lottoSalesMachine.guideInputLottoPurchaseAmount())
    val inputLottoPurchaseWon = readLine()
    val lottos = lottoSalesMachine.purchase(inputLottoPurchaseWon.toInt())

}
