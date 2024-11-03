package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbers.distinct().size == numbers.size) { "[ERROR] 로또 번호에는 중복된 숫자가 있을 수 없습니다." }
    }

    fun containsBonusNumber(bonusNumer: Int): Boolean {
        return bonusNumer in numbers
    }
}
