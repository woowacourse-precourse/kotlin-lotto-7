package lotto.util

import lotto.model.Lotto
import lotto.view.Input

class Transformer {
    fun stringToIntInt(string: List<String>): List<Int> {
        val int = mutableListOf<Int>()
        string.forEach { int.add(it.toInt()) }
        return int
    }

}