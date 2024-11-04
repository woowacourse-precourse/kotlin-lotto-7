package lotto
/**
 * 로또 번호를 관리하는 클래스
 */
class Lotto(private val numbers: List<Int>) {
    init {
        validate()
    }

    private fun validate() {
        validateSize()
        validateRange()
        validateDuplicate()
    }

    private fun validateSize() {
        require(numbers.size == LottoConfig.LOTTO_NUMBER_COUNT) {
            Message.ERROR_INVALID_WINNING_NUMBERS
        }
    }

    private fun validateRange() {
        require(numbers.all { it in LottoConfig.MIN_NUMBER..LottoConfig.MAX_NUMBER }) {
            Message.ERROR_INVALID_NUMBER_RANGE
        }
    }

    private fun validateDuplicate() {
        require(numbers.size == numbers.toSet().size) {
            Message.ERROR_INVALID_WINNING_NUMBERS
        }
    }

    fun getNumbers(): List<Int> {
        return numbers.sorted()
    }
}