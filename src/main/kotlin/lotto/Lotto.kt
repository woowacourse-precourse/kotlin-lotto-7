package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) {ErrorMessage.LOTTO_SIZE_ERROR.message }
        require(numbers.toSet().size == 6) {ErrorMessage.LOTTO_DUPLICATION_ERROR.message}
        require(numbers.all { it in 1..45 }) {ErrorMessage.LOTTO_RANGE_ERROR.message}

    }

    // TODO: 추가 기능 구현
}
