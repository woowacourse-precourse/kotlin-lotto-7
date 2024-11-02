package lotto.model

object Processor {
    fun winningNumSplit(num: String): List<Int> {
        val numList = num.split(",").map { it.toInt() }
        return numList
    }
}