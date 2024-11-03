package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbers.toSet().size == numbers.size) { "[ERROR] 로또 번호는 중복될 수 없습니다."}
    }

    fun getNumbers(): List<Int> {
        return numbers
    }

    override fun toString(): String {
        return numbers.sorted().toString() //오름차순 정렬 후 문자열 반환
    }
}
