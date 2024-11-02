package lotto.model

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbers.all { it in 1..45 }) { "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다." }
        require(numbers.distinct().size == numbers.size) { "[ERROR] 로또 번호에는 중복이 있을 수 없습니다." }
    }

    fun getNumbers(): List<Int> {
        return numbers.sorted() // 번호를 오름차순으로 정렬해서 반환
    }

    fun compareWithWinningNumbers(winningNumbers: List<Int>, bonusNumber: Int): Rank {
        val matchCount = numbers.count { it in winningNumbers }
        val bonusMatch = numbers.contains(bonusNumber)

        return when {
            matchCount == 6 -> Rank.FIRST
            matchCount == 5 && bonusMatch -> Rank.SECOND
            matchCount == 5 -> Rank.THIRD
            matchCount == 4 -> Rank.FOURTH
            matchCount == 3 -> Rank.FIFTH
            else -> Rank.MISS // 이 부분은 필요 없다면 삭제
        }
    }
}