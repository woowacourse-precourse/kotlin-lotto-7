package lotto.util

import lotto.model.Lotto
import lotto.view.Input

class Transformer {
    fun stringToIntList(string: List<String>): List<Int> {
        val int = mutableListOf<Int>()
        string.forEach { int.add(it.toInt()) }
        return int
    }

    fun stringToLotto(winningNumber: String): Lotto {
        return Lotto(Transformer().stringToIntList(winningNumber.split(',')))
    }
}