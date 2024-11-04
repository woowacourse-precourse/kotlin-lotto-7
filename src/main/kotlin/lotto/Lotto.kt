package lotto

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbers.size == numbers.distinct().size) { "[ERROR] 로또 당첨 번호는 중복이 아닌 6개의 숫자여야 합니다." }
        require(numbers.all { it in 1..45}) {"[ERROR] 로또 당첨 번호는 1~45까지의 숫자로만 입력해야 합니다."}
        require(numbers.isNotEmpty()) {"[ERROR] 로또 당첨 번호는 중복이 아닌 6개의 숫자여야 합니다."}
    }
    }

    // TODO: 추가 기능 구현
}
