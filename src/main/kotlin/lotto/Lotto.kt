package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
    }

    fun getLottoNumber(): List<Int> {
        return numbers
    }

    fun winConditionCheck(winNumbers: List<Int>, bonusNumber: Int): WinCondition {
        val union = winNumbers + numbers
        val match = union.groupBy { it }.filter { it.value.size > 1 }.flatMap { it.value }.distinct().size
        var bonus = false
        if (match == 5) {
            bonus = numbers.contains(bonusNumber)
        }
        return winConditions(match, bonus)
    }

    private fun winConditions(match: Int, bonus: Boolean): WinCondition {
        try {
            val win = findCondition(match, bonus)
            return win
        } catch (e: IllegalArgumentException) {
            return WinCondition.NONE
        }
    }

    // TODO: 추가 기능 구현
}
