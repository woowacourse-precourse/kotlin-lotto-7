package lotto

const val FIRST_PRIZE = 2000000000
const val SECOND_PRIZE = 30000000
const val THIRD_PRIZE = 1500000
const val FOURTH_PRIZE = 50000
const val FIFTH_PRIZE = 5000


class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
    }

    private fun switchRank(matchNumberSize: Int, isBonusNumberMatch: Boolean): Int {
        if (matchNumberSize == 6) return 1
        if (matchNumberSize == 5 && !isBonusNumberMatch) return 2
        if (matchNumberSize == 5) return 3
        if (matchNumberSize == 4) return 4
        if (matchNumberSize == 3) return 5
        else throw IllegalArgumentException()
    }

    fun getRank(lottoNumbers: List<Int>, bonusNumber: Int): Int {
        var count = numbers.filter { number -> lottoNumbers.any { it == number } }
        val isBonusNumberMatch = numbers.any { it == bonusNumber }

        return switchRank(count.size, isBonusNumberMatch)
    }
}
