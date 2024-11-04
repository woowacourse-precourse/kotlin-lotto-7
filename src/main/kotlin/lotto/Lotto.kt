package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다. 로또 번호를 다시 입력해주세요." }
    }

    fun getNumbers() = this.numbers
}
