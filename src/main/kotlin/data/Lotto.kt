package data

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbers.all { it in 1..45 }) { "[ERROR] 로또 번호는 1부터 45 사이여야 합니다." }
        require(numbers.size == numbers.toSet().size) { "[ERROR] 같은 번호는 없어야 합니다." }
    }

    // 읽기 전용 번호 반환
    val read: List<Int>
        get() = numbers

    // 번호 포함 여부 확인
    fun contains(number: Int): Boolean {
        return numbers.contains(number)
    }

    // 로또 번호 출력
    override fun toString(): String {
        return numbers.joinToString(", ") { it.toString() }
    }
}