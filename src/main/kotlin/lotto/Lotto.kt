package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbers.toSet().size == 6) { "[ERROR] 로또 번호는 중복이 없어야 합니다." }
        require(numbers.all { it in 1..45 }) { "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다." }
    }

}

class BonusNumber(private val bonusnumber: Int, winnernumber: List<Int>) {
    init {
        require(bonusnumber in 1..45) { "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다." }
        require(bonusnumber !in winnernumber) { "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다." }
    }
}