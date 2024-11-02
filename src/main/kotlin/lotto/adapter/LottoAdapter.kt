package lotto.adapter

import lotto.Lotto

object LottoAdapter {
    private const val DELIMITER: String = ","

    fun toLottoModel(input: String): Lotto {
        val numbers = input.split(DELIMITER).map { it.trim().toInt() }.sorted()
        return Lotto(numbers)
    }
}