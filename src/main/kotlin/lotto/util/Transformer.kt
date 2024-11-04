package lotto.util

class Transformer {
    fun stringToIntInt(before: List<String>): List<Int> {
        val after = mutableListOf<Int>()
        before.forEach { after.add(it.toInt()) }
        return after
    }

}