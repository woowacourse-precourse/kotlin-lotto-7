package lotto.model.lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbers.distinct().size == numbers.size) { "[ERROR] 로또 번호는 중복될 수 없습니다." }
        require(numbers.all { it in 1..45 }) { "[ERROR] 로또 번호는 1부터 45 사이여야 합니다." }
    }

    // TODO: 추가 기능 구현
    fun getNumbers(): List<Int> = numbers

    fun countMatchingNumbers(winningNumbers: List<Int>): Int {
        return numbers.count { it in winningNumbers }
    }

    fun matchBonusNumber(bonusNumber: Int): Boolean {
        return bonusNumber in numbers
    }
}
