package lotto

// numbers : 입력받은 로또 번호
class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbers.all { it in 1..45 }) { "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다." }
        require(numbers.distinct().size == 6) { "[ERROR] 로또 번호는 중복되지 않아야 합니다." }
    }

    // 번호 일치 개수 반환
    fun matchCount(winningNumbers: List<Int>): Int {
        return numbers.count { it in winningNumbers }
    }

}