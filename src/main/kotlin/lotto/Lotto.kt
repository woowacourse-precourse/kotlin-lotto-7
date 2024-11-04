package lotto


class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require( checkDuplicationLottoNumbers(numbers)) { DUPLICATION_NUMBER }
    }

    private fun checkDuplicationLottoNumbers(lottoNumbers: List<Int>): Boolean {
        val duplicationNumbers = lottoNumbers.filterIndexed { idx, it -> lottoNumbers.indexOf(it) != idx }
        if (duplicationNumbers.isNotEmpty()) {
            println(DUPLICATION_NUMBER)
            return false
        }
        return true
    }

    private fun switchRank(matchNumberSize: Int, isBonusNumberMatch: Boolean): RANK {
        if (matchNumberSize == 6) return RANK.FIRST
        if (matchNumberSize == 5 && isBonusNumberMatch) return RANK.SECOND
        if (matchNumberSize == 5) return RANK.THIRD
        if (matchNumberSize == 4) return RANK.FOURTH
        if (matchNumberSize == 3) return RANK.FIFTH
        return RANK.OTHERS
    }

    fun getRank(lottoNumbers: List<Int>, bonusNumber: Int): RANK {
        val count = numbers.filter { number -> lottoNumbers.any { it == number } }
        val isBonusNumberMatch = numbers.any { it == bonusNumber }

        return switchRank(count.size, isBonusNumberMatch)
    }
}
