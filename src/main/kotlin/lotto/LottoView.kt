package lotto

import camp.nextstep.edu.missionutils.Console

class LottoView {

    fun getBuyAmount(): Int {
        println(Constant.INPUT_BUY_MESSAGE)
        while (true) {
            try {
                val buyAmount = Console.readLine()
                if (checkBuyAmount(buyAmount)) return buyAmount.toInt()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun checkBuyAmount(buyAmount: String): Boolean {
        try {
            if (buyAmount.toInt() % 1000 == 0) return true
            else throw Exception()
        } catch (e: Exception) {
            throw IllegalArgumentException(Constant.ERROR_BUY_AMOUNT_INVALID_MESSAGE)
        }
    }

    fun showBoughtLotto(lottoAmount: Int, lottos: ArrayList<Lotto>) {
        println("\n$lottoAmount" + Constant.BOUGHT_LOTTO_MESSAGE)
        println(lottos.joinToString("\n") { "[" + it.getLottoValue().joinToString(", ") + "]" })
        println()
    }

    fun getWinnerNumber(): List<Int> {
        while (true) {
            try {
                println(Constant.INPUT_WINNER_NUMBER)
                val winnerNumber = Console.readLine()
                if (checkWinnerNumber(winnerNumber)) return winnerNumber.split(",").map { it.toInt() }
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun checkWinnerNumber(winnerNumber: String): Boolean {
        try {
            if (winnerNumber.split(",").map { if (it.toInt() in 1..45) it.toInt() else throw Exception() }
                    .toSet().size == 6
            ) return true
            else throw Exception()
        } catch (e: Exception) {
            throw IllegalArgumentException(Constant.ERROR_WINNER_NUMBER_INVALID_MESSAGE)
        }
    }

    fun getSpecialNumber(winnerNumber: List<Int>): Int {
        while (true) {
            try {
                println(Constant.INPUT_SPECIAL_NUMBER_MESSAGE)
                val specialNumber = Console.readLine()
                if (checkSpecialNumber(specialNumber, winnerNumber)) return specialNumber.toInt()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun checkSpecialNumber(specialNumber: String, winnerNumber: List<Int>): Boolean {
        try {
            if (specialNumber.toInt() in 1..45) {
                if (!winnerNumber.contains(specialNumber.toInt())) return true
                else throw Exception()
            } else throw Exception()
        } catch (e: Exception) {
            throw IllegalArgumentException(Constant.ERROR_SPECIAL_NUMBER_INVALID_MESSAGE)
        }
    }

    fun showLottoResult(lottoResult: List<Int>) {
        println(Constant.RESULT_MESSAGE)
        println(Constant.RESULT_THREE_MATCH.format(lottoResult[0]))
        println(Constant.RESULT_FOUR_MATCH.format(lottoResult[1]))
        println(Constant.RESULT_FIVE_MATCH.format(lottoResult[2]))
        println(Constant.RESULT_FIVE_SPECIAL_MATCH.format(lottoResult[3]))
        println(Constant.RESULT_SIX_MATCH.format(lottoResult[4]))
    }

    fun showReturnRate(returnRate: Double) {
        println("총 수익률은 ${String.format("%.1f", returnRate)}%입니다.")
    }
}