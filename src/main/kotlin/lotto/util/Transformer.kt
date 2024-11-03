package lotto.util

class Transformer {
    fun stringToIntList(string: List<String>): List<Int> {
        val int = mutableListOf<Int>()
        string.forEach { int.add(it.toInt()) }
        return int
    }
}