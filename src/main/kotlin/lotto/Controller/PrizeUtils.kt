package lotto.Controller

import lotto.Model.Prize

fun getPrizesToPrint(): List<Prize> {
    return Prize.values()
        .filter { it.matchCount >= 3 }
        .sortedBy { it.matchCount }
}