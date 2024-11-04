package lotto.data

class Lotto(private val numbers: String) {
    init {
        require(numbers.split(",").all { it.toIntOrNull() != null }) { "[ERROR] 로또 번호는 정수여야 합니다." }
        require(numbers.split(",").map { it.toInt() }.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbers.split(",").all { it.toInt() in 1..45 }) { "[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다." }
        require(numbers.split(",").distinct().size == 6) { "[ERROR] 당첨 번호는 중복될 수 없습니다." }
    }

    constructor(numbers: List<Int>) : this(numbers.joinToString(","))   // 단위 테스트 시 인자가 `List<Int>`인 경우

    fun getWinningNumber(): List<Int> = numbers.split(",").map { it.toInt() }
}
