package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다. 로또 번호를 다시 입력해주세요." }
        require(numbers.distinct().count() == 6) { "[ERROR] 로또 번호는 중복된 숫자가 없어야 합니다. 로또 번호를 다시 입력해주세요." }
        require(numbers.count { it < 1 || it > 45 } == 0) { "[ERROR] 로또 번호는 1부터 45 사이의 정수여야 합니다. 로또 번호를 다시 입력해주세요." }
    }

    fun getNumbers() = this.numbers
}
