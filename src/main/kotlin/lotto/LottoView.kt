package lotto

import camp.nextstep.edu.missionutils.Console

class LottoView {

    fun getBuyAmount(): Int {
        println(Constant.INPUT_BUY_MESSAGE)
        return Console.readLine().toInt()
    }

    fun showBoughtLotto(lottoAmount: Int, lottos: ArrayList<Lotto>) {
        println("\n$lottoAmount" + Constant.BOUGHT_LOTTO_MESSAGE)
        println(lottos.joinToString("\n") { "[" + it.getLottoValue().joinToString(", ") + "]" })
        println()
    }

    fun getWinnerNumber(): List<Int> {
        println(Constant.INPUT_WINNER_NUMBER)
        return Console.readLine().split(",").map { it.toInt() }
    }

    fun getSpecialNumber() : Int {
        println(Constant.INPUT_SPECIAL_NUMBER_MESSAGE)
        return Console.readLine().toInt()
    }

    fun showLottoResult(lottoResult : List<Int>){
        println(Constant.RESULT_MESSAGE)
        println(Constant.RESULT_THREE_MATCH.format(lottoResult[0]))
        println(Constant.RESULT_FOUR_MATCH.format(lottoResult[1]))
        println(Constant.RESULT_FIVE_MATCH.format(lottoResult[2]))
        println(Constant.RESULT_FIVE_SPECIAL_MATCH.format(lottoResult[3]))
        println(Constant.RESULT_SIX_MATCH.format(lottoResult[4]))
    }

    fun showReturnRate(returnRate : Double){
        println("총 수익률은 ${String.format("%.1f", returnRate)}%입니다.")
    }
}