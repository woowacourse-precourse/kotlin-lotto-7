package lotto.model

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == WINNING_BALL_COUNT) { ERROR_REQUIRE_SIX_NUMBERS_MESSAGE }
    }

    fun sort(): List<Int> {
        return numbers.sorted()
    }

    companion object {
        const val WINNING_BALL_COUNT = 6
        const val ERROR_REQUIRE_SIX_NUMBERS_MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다."
    }
}
