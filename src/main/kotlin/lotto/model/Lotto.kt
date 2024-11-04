package lotto.model

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == NUMBERS_SIZE) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbers.size == numbers.distinct().size) { "[ERROR] 중복 숫자를 제거해주세요." }
    }


    companion object {
        private const val NUMBERS_SIZE = 6
    }
}
