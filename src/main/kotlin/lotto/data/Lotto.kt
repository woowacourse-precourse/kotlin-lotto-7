package lotto.data

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_NUMBER_COUNT) { NUMBER_COUNT_NOT_SIX_ERROR_MESSAGE }
        require(numbers.all { it in LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER }) { NUMBER_RANGE_OUT_ERROR_MESSAGE }
        require(numbers.distinct() == numbers) { NUMBER_NOT_UNIQUE_ERROR_MESSAGE }
        require(numbers.sorted() == numbers) { NUMBER_NOT_SORT_ERROR_MESSAGE }
    }

    // TODO: 추가 기능 구현
    companion object {
        private const val NUMBER_COUNT_NOT_SIX_ERROR_MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다."
        private const val NUMBER_RANGE_OUT_ERROR_MESSAGE = "[ERROR] 로또 번호는 1 부터 45 까지 지정 가능합니다."
        private const val NUMBER_NOT_UNIQUE_ERROR_MESSAGE = "[ERROR] 중복된 로또 번호가 있습니다."
        private const val NUMBER_NOT_SORT_ERROR_MESSAGE = "[ERROR] 오름차순으로 정렬되어 있지 않습니다."
        private const val LOTTO_NUMBER_COUNT = 6
        private const val LOTTO_MAX_NUMBER = 45
        private const val LOTTO_MIN_NUMBER = 1
    }
}
