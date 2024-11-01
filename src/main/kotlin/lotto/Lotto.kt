package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }

        numbers.forEach { number ->
            require(number in 1..45) { "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다." }
        }

        require(numbers.toSet().size == numbers.size) { "[ERROR] 로또 번호에는 중복된 숫자가 포함될 수 없습니다." }
    }
}
