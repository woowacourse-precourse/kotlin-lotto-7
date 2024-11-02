package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbers.all { it in 1..45 }) { "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다." }
        require(numbers.distinct().size == numbers.size) { "[ERROR] 로또 번호에는 중복이 있을 수 없습니다." }
    }

    fun getNumbers(): List<Int> {
        return numbers.sorted() // 번호를 오름차순으로 정렬해서 반환
    }
}