package lotto.domain.entity

class Lotto(private val numbers: List<Int>) {
    val nums = numbers

    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
    }

    companion object {
        fun List<Int>.toLottoNumbers(): Lotto = Lotto(this)
    }
}
