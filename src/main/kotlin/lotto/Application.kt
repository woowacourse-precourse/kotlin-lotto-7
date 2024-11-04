package lotto

import camp.nextstep.edu.missionutils.Console.readLine

fun main() {
    val lottoSalesMachine = LottoSalesMachine()
    val lottos = lottoSalesMachine.processPurchase()
    val lottoJudge = LottoJudge()
    lottoJudge.saveUserInput()
    lottoJudge.printWinningStatistics(lottos)
}
