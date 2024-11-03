package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(isLottoNumberSize()) { "$ERROR $LOTTO_SIZE_MESSAGE" }
        require(isDuplicate()) { "$ERROR $LOTTO_NUMBER_DUPLICATE_MESSAGE" }
        numbers.forEach {
            require(isNumberInRange(it)) { "$ERROR $LOTTO_NUMBER_NOT_IN_RANGE_MESSAGE" }
        }
        require(numbers == numbers.sorted()) {"$ERROR $LOTTO_NUMBER_NOT_ASCENDING"}
    }

    private fun isLottoNumberSize() = numbers.size == LOTTO_SIZE

    private fun isNumberInRange(it: Int) = it in MIN_NUM..MAX_NUM

    private fun isDuplicate() = numbers.distinct().size == numbers.size

    companion object {
        const val LOTTO_SIZE = 6
        const val MIN_NUM = 1
        const val MAX_NUM = 45

        const val ERROR = "[ERROR]"
        const val LOTTO_SIZE_MESSAGE = "로또 번호는 6개여야 합니다."
        const val LOTTO_NUMBER_DUPLICATE_MESSAGE = "로또 번호는 중복될 수 없습니다."
        const val LOTTO_NUMBER_NOT_IN_RANGE_MESSAGE = "로또 번호는 중복될 수 없습니다."
        const val LOTTO_NUMBER_NOT_ASCENDING = "로또 번호가 오름차순 정렬되지 않았습니다."
    }
}
