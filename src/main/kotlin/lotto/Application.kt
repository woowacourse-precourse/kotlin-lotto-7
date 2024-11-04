package lotto

import camp.nextstep.edu.missionutils.Console.readLine

fun main() {
    val lottoSalesMachine = LottoSalesMachine()
    val lottos = lottoSalesMachine.processPurchase()

    println("\n당첨 번호를 입력해 주세요.")
    val inputWinnerNumbers = readLine().split(",").map { it.toInt() }
    val lottoJudge = LottoJudge()
    lottoJudge.setLottoWinnerNumbers(inputWinnerNumbers)
    println("\n보너스 번호를 입력해 주세요.")
    val inputBonusNumber = readLine().toInt()
    lottoJudge.setLottoBonusNumber(inputBonusNumber)

    lottoJudge.printWinningStatistics(lottos)
}
