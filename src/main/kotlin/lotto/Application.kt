package lotto

import camp.nextstep.edu.missionutils.Console.readLine

fun main() {
    val lottoSalesMachine = LottoSalesMachine()
    println(lottoSalesMachine.guideInputLottoPurchaseAmount())
    val inputLottoPurchaseWon = readLine()
    val lottos = lottoSalesMachine.purchase(inputLottoPurchaseWon.toInt())

    println("\n당첨 번호를 입력해 주세요.")
    val inputWinnerNumbers = readLine().split(",").map { it.toInt() }
    val lottoJudge = LottoJudge()
    lottoJudge.setLottoWinnerNumbers(inputWinnerNumbers)
}
