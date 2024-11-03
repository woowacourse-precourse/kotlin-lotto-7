package lotto.domain

class Lotto(
    private val numbers: List<Int>
) {

    init {
        validateLotto(numbers)
    }

    fun getLotto(): List<Int> = numbers.toList()

    private fun validateLotto(numbers: List<Int>) {
        requireNotEmpty(numbers)
        requireValidSize(numbers)
        requireUnique(numbers)
    }

    private fun requireNotEmpty(numbers: List<Int>) =
        require(numbers.isNotEmpty()) { "[ERROR] 로또 번호는 비어있을 수 없습니다." }

    private fun requireValidSize(numbers: List<Int>) =
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }

    private fun requireUnique(numbers: List<Int>) =
        require(numbers.distinct().size == numbers.size) { "[ERROR] 로또 번호는 중복될 수 없습니다." }

}
