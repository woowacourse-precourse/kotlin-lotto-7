package lotto

class Lotto(private val numbers: List<Int>) {
    val lottoNumber: List<Int>
        get() = numbers

    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbers.all { it in 1..45 }) { "[ERROR] 로또 번호는 1~45 사이의 숫자여야 합니다." }
    }

    // TODO: 추가 기능 구현
}
