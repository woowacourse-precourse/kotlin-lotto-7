package lotto.model

object Processor {
    fun moneyProcess(money: Int): Int {
        if (money % 1000 == 0) return money / 1000
        return 0
    }

    fun winningNumSplit(num: String): List<Int> {
        val numList = num.split(",").map { it.toInt() }
        return numList
    }
}