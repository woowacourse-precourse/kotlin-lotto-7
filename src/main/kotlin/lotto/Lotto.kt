package lotto


class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbers.size == numbers.distinct().size) { "[ERROR] 로또 당첨 번호는 중복이 아닌 6개의 숫자여야 합니다." }
        require(numbers.all { it in 1..45}) {"[ERROR] 로또 당첨 번호는 1~45까지의 숫자로만 입력해야 합니다."}
        require(numbers.isNotEmpty()) {"[ERROR] 로또 당첨 번호는 중복이 아닌 6개의 숫자여야 합니다."}
    }

    fun checkMatch(outputLottoNumbers: MutableList<List<Int>>, bonusLottoNum: Int): MutableList<Int> {
        val results = MutableList(5) { 0 }

        outputLottoNumbers.forEach { outputNum ->
            val count = outputNum.count { it in numbers }
            val isBonusMatch = bonusLottoNum in outputNum
            val rank = checkWinning(count, isBonusMatch)

            rank?.let { results[it] += 1 }
        }

        return results
    }

    fun checkWinning(count: Int, bonusMatch: Boolean): Int? {
        return when {
            count == 6 -> 4 // 1등
            count == 5 && bonusMatch -> 3 // 2등
            count == 5 -> 2 // 3등
            count == 4 -> 1 // 4등
            count == 3 -> 0 // 5등
            else -> null
        }
    }
}
