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
}