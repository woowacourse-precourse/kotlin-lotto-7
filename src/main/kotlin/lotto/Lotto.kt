package lotto


class Lotto(private val numbers: List<Int>) {
    fun getNumbers(): List<Int> {
        return numbers
    }

    fun getLottoResultAsRank(winningNumbers: List<Int>, bonusNumber: Int): LottoRank {
        val matchCount = numbers.count { it in winningNumbers }

        return when (matchCount) {
            6 -> LottoRank.FIRST
            5 -> if (bonusNumber in numbers) LottoRank.SECOND else LottoRank.THIRD
            4 -> LottoRank.FOURTH
            3 -> LottoRank.FIFTH
            else -> LottoRank.NONE
        }
    }
}
