package lotto.adapter

import lotto.domain.model.Lotto

object LottoAdapter {
    private const val DELIMITER: String = ","

    fun makeLottoModel(input: String): Lotto {
        val numbers = input.split(DELIMITER).map { it.trim().toInt() }.sorted()
        return Lotto(numbers)
    }
}