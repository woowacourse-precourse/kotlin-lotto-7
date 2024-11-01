package lotto.domain.entity

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
    }

    companion object {
        private fun List<Int>.toLottoNumbers(): Lotto = Lotto(this)
    }
}
